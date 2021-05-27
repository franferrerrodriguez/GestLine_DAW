import { Component, OnInit, ɵConsole } from '@angular/core';
import { NgForm } from '@angular/forms';
import * as CryptoJS from 'crypto-js';
import { Client } from '../../models/Client.class';
import { AuthService } from '../../services/auth/auth.service';
import { ClientmanagementService } from '../../services/clientmanagement.service';
import { DataUtils } from '../../Utils/DataUtils.class';
import { User } from 'src/app/models/user.class';
import { Notification } from '../../models/Notification.class';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  public loading:boolean;
  public notification: Notification;
  public clientData:any;
  public dataUtils:DataUtils;
  public documentTypes:string[];
  public addressTypes:string[];
  public countries:string[];
  public user:User;

  public client: Client = {
    document: '',
    documentType: '',
    clientType: '',
    name: '',
    firstSurname: '',
    secondSurname: '',
    birthDate: '',
    email: '',
    onlineInvoice: false,
    password: '',
    repeatPassword: '',
    address: { 
      type: '',
      direction: '',
      number: '',
      stairs: '',
      floor: '',
      door: '',
      location: '',
      province: '',
      postalCode: '',
      country: ''
    },
    billing: { 
      entity: '',
      office: '',
      dc: '',
      account: '',
      address: {
        type: '',
        direction: '',
        number: '',
        stairs: '',
        floor: '',
        door: '',
        location: '',
        province: '',
        postalCode: '',
        country: ''
      }
    }
  }

  constructor(public authService: AuthService, private clientmanagementService: ClientmanagementService) {
    this.loading = true;
  }

  ngOnInit(): void {
    this.loading = false;
    this.dataUtils = new DataUtils();
    this.documentTypes = this.dataUtils.getDocumentType();
    this.addressTypes = this.dataUtils.getAddressType();
    this.countries = this.dataUtils.getCountries();

    this.user = this.authService.getCurrentUser();

    this.getClientManagementData();
  }

  getClientManagementData() {
    if(this.authService.getCurrentUser()){
      return this.clientmanagementService
      .getClientByDocument(this.authService.getCurrentUser().document)
      .subscribe(
        data => {
          this.clientData = data.result;
          this.client = data.result;
        },
        error => {
          console.log(error);
          this.notification = new Notification(Notification.Type().Error, "", false);
        }
      );
    }
  }

  save(form: NgForm) {
    this.loading = true;

    if (form.valid) {
      this.loading = false;

      let changePassword;
      if(form.controls.password.value || form.controls.repeatPassword.value)
        if(form.controls.password.value == form.controls.repeatPassword.value)
          changePassword = true;
        else
          changePassword = false;
  
      if(changePassword == false){
        this.notification = new Notification(Notification.Type().Error, "Las contraseñas no coinciden.");
        this.client.password = '';
        this.client.repeatPassword = '';
      } else {
        if(changePassword) {
          this.user.password = CryptoJS.MD5(form.controls.password.value).toString();
          console.log(this.user);
          return this.authService
          .updateUser(this.user)
          .subscribe(
            data => {
              console.log(data);
            },
            error => {
              console.log(error);
              this.notification = new Notification(Notification.Type().Error, "", false);
              this.loading = false;
            }
          );
        }
        return this.clientmanagementService
        .updateClient(this.client)
        .subscribe(
          data => {
            console.log(data);
            this.notification = new Notification(Notification.Type().Success);
          },
          error => {
            console.log(error);
            this.loading = false;
            this.notification = new Notification(Notification.Type().Error, "", false);
          }
        );
      }
    } else {
      console.log('Form not valid.');
      this.loading = false;
      this.notification = new Notification(Notification.Type().Error);
    }
  }

}