import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-documentation',
  templateUrl: './documentation.component.html',
  styleUrls: ['./documentation.component.css']
})
export class DocumentationComponent implements OnInit {

  public name: string;
  public version: string;
  public scripts: any[];
  public dependencies: any[];
  public devDependencies: any[];

  public microservices = [
    {
      'name': 'ZUUL-API-GATEWAY',
      'endpoint': '',
      'actuator': 'http://localhost:9061/actuator'
    },
    {
      'name': 'EUREKA-SERVER',
      'endpoint': 'http://localhost:8761',
      'actuator': 'http://localhost:8761/actuator'
    },
    {
      'name': 'TURBINE',
      'endpoint': 'http://localhost:8989',
      'actuator': 'http://localhost:8989/actuator'
    },
    {
      'name': 'MS-CONFIG-SERVER',
      'endpoint': '',
      'actuator': 'http://localhost:8888/actuator'
    },
    {
      'name': 'MS-AUTHENTICATION',
      'endpoint': 'http://localhost:8000/v1/all',
      'actuator': 'http://localhost:8000/actuator'
    },
    {
      'name': 'MS-CLIENT-MANAGEMENT',
      'endpoint': 'http://localhost:8001/v1/all',
      'actuator': 'http://localhost:8001/actuator'
    },
    {
      'name': 'MS-CONTRACT',
      'endpoint': 'http://localhost:8002/v1/all',
      'actuator': 'http://localhost:8002/actuator'
    },
    {
      'name': 'MS-INVOICE',
      'endpoint': 'http://localhost:8003/v1/all',
      'actuator': 'http://localhost:8003/actuator'
    }
  ]

  constructor() { }

  ngOnInit(): void {
    this.scripts = new Array();
    this.dependencies = new Array();
    this.devDependencies = new Array();

    this.name = environment.packagejson.name;
    this.version = environment.packagejson.version;

    for(let i = 0; i < Object.keys(environment.packagejson.scripts).length; i++){
      this.scripts.push({
        "name": Object.keys(environment.packagejson.scripts)[i],
        "value": environment.packagejson.scripts[Object.keys(environment.packagejson.scripts)[i]]
      });
    }

    for(let i = 0; i < Object.keys(environment.packagejson.dependencies).length; i++){
      this.dependencies.push({
        "name": Object.keys(environment.packagejson.dependencies)[i],
        "value": environment.packagejson.dependencies[Object.keys(environment.packagejson.dependencies)[i]]
      });
    }

    for(let i = 0; i < Object.keys(environment.packagejson.devDependencies).length; i++){
      this.devDependencies.push({
        "name": Object.keys(environment.packagejson.devDependencies)[i],
        "value": environment.packagejson.devDependencies[Object.keys(environment.packagejson.devDependencies)[i]]
      });
    }
    
  }

}