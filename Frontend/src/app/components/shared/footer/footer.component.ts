import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  titleApp: string;
  autor:string;
  email:string;
  anno:number;
  message:string;
  linkedinUrl:string;
  description:string;
  
  constructor(public authService: AuthService) {
    this.titleApp = environment.packagejson.name;
    this.autor = "Francisco José Ferrer Rodríguez";
    this.email = "franferrerrodriguez@gmail.com";
    this.anno = new Date().getFullYear();
    this.message = "Gestiona tus líneas de una manera sencilla.";
    this.linkedinUrl = "https://es.linkedin.com/in/francisco-jos%C3%A9-ferrer-rodr%C3%ADguez-36a1258b";
    this.description = `GestLine es una aplicación web que simula un área de clientes
     de una compañía de telecomunicaciones. Está desarrollada en tecnologías Angular 
     (Frontend) y Java (Backend) como proyecto final del Ciclo Formativo de Grado 
     Superior en Desarrollo de Aplicaciones Web impartido en el I.E.S. 
     San Severo Ochoa.`;
  }

  ngOnInit(): void {
  }

}
