import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { Utils } from '../../Utils/Utils.class';
import { ContractService } from '../../services/contract.service';
import { Notification } from '../../models/Notification.class';

@Component({
  selector: 'app-consumption',
  templateUrl: './consumption.component.html',
  styleUrls: ['./consumption.component.css']
})
export class ConsumptionComponent implements OnInit {

  public loading:boolean;
  public notification: Notification;
  public contractData:any;
  public document:string;
  public utils:Utils;
  public contracts:string[];
  
  constructor(private activatedRoute:ActivatedRoute, private authService: AuthService, private contractService: ContractService) { }

  ngOnInit(): void {
    this.loading = false;
    this.utils = new Utils();
    this.document = this.authService.getCurrentUser().document;
    this.getContractByDocument(this.document);
  }

  getContractByDocument(document:string) {
    this.loading = true;
    return this.contractService
    .getContractByDocumentSrv(document)
    .subscribe(
      data => {
        this.loading = false;

        // Get the contracts by all or URL phone
        let phone:string;
        this.activatedRoute.params.subscribe(params => {
          phone = params['phone'];
        });
        this.contractData = this.contractService.getContractByPhone(data.result, phone);
      },
      error => {
        console.log(error);
        this.loading = false;
        this.notification = new Notification(Notification.Type().Error, "", false);
      }
    );
  }

}