import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { map } from "rxjs/operators";
import { API } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http: HttpClient) { }

  headers: HttpHeaders = new HttpHeaders({
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*"
  });

  getInvoiceByDocumentSrv(document: string, numInvoices:number): Observable<any> {
    const url = API.msinvoicev1 + "lastInvoices/" + document + "/" + numInvoices;
    return this.http
      .get(
        url,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

  getInvoiceById(invoiceId:number, invoices:any[]){
    let invoiceReturn:any = null;
    invoices.forEach(function (invoice) {
      if(invoice.id == invoiceId)
        invoiceReturn = invoice;
    });
    return invoiceReturn;
  }

  downloadInvoice(name:string){
    return API.msinvoicev1 + "downloadInvoice/" + name;
  }

  showInvoice(name:string){
    return API.msinvoicev1 + "showInvoice/" + name;
  }

}