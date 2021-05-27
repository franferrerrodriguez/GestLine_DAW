import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  public contracts:any;
  public allContractsLines:any;

  constructor() { }

  searchPhone(phone:string){
    let filterContracts:any[] = [];
    if(!phone)
      this.contracts.contractLines = this.allContractsLines;
    else{
      this.allContractsLines.forEach(function (contract) {
        if(contract.phone.includes(phone))
          filterContracts.push(contract);
      });
      this.contracts.contractLines = filterContracts;
    }
  }

  getContractsFilter(param:any){
    this.contracts = param;
    this.allContractsLines = this.contracts.contractLines;
    return this.contracts;
  }

}