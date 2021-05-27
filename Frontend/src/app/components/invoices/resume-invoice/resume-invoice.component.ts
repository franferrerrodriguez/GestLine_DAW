import { Component, OnInit, Input, SimpleChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../../../services/auth/auth.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { Utils } from '../../../Utils/Utils.class';
import { Notification } from '../../../models/Notification.class';

@Component({
  selector: 'app-resume-invoice',
  templateUrl: './resume-invoice.component.html',
  styleUrls: ['./resume-invoice.component.css']
})
export class ResumeInvoiceComponent implements OnInit {

  public title:string;
  public loading:boolean;
  public notification: Notification;
  public invoiceResumeData:any;
  public document:string;
  public month:string;
  public numInvoices:number;
  public url:string;
  public totalAmount:number;
  @Input() chartSelected: any;

  constructor(private activatedRoute:ActivatedRoute, private authService: AuthService, private invoiceService: InvoiceService) { }

  ngOnInit(): void {
    this.loading = false;
    this.title = "Resumen de factura";
    this.numInvoices = 6;
    this.document = this.authService.getCurrentUser().document;
    this.getInvoiceByDocument();
  }

  ngOnChanges(changes: SimpleChanges) {
    let utils = new Utils();
    if(this.chartSelected)
      this.month = utils.getMonthByNumber(new Date(this.chartSelected.invoiceDate));
  }

  getInvoiceByDocument() {
    this.loading = true;
    if(this.document && this.numInvoices){
      return this.invoiceService
      .getInvoiceByDocumentSrv(this.document, this.numInvoices)
      .subscribe(
        data => {
          this.invoiceResumeData = data.result;
          this.loading = false;
          this.activatedRoute.params.subscribe(params => {
            let invoice = this.invoiceService.getInvoiceById(params['id'], this.invoiceResumeData);
            if(invoice)
              this.chartSelected = invoice;
         });
         let utils = new Utils();
         this.month = utils.getMonthByNumber(new Date(this.chartSelected.invoiceDate));
        },
        error => {
          console.log(error);
          this.loading = false;
          this.notification = new Notification(Notification.Type().Error, "", false);
        }
      );
    }else{
      this.notification = new Notification(Notification.Type().Error, "Hay facturas disponibles.", false);
    }
  }

  getTotalAmount(): number {
    let totalAmount:number = 0;
    this.chartSelected.invoices.forEach(function (value) {
      totalAmount += value.totalAmount;
    }); 
    return totalAmount;
  }

  downloadInvoice(){
    this.url = this.invoiceService.downloadInvoice("Factura.pdf");
  }

  showInvoice(){
    this.url = this.invoiceService.showInvoice("Factura.pdf");
  }

}