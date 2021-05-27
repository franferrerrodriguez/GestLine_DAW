import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../services/auth/auth.service';
import { InvoiceService } from 'src/app/services/invoice.service';
import { Utils } from 'src/app/Utils/Utils.class';
import { Notification } from '../../../models/Notification.class';

@Component({
  selector: 'app-chart-invoices',
  templateUrl: './chart-invoices.component.html',
  styleUrls: ['./chart-invoices.component.css']
})
export class ChartInvoicesComponent implements OnInit {

  public title:string;
  public loading:boolean;
  public notification: Notification;
  public invoiceChartData:any;
  public document:string;
  public numInvoices:number;
  public chartType: string = 'horizontalBar';
  public chartDatasets: Array<any> = [{ }];
  public monthLabel: Array<String>;
  public chartSelected:any;
  @Output() chartSelectedEmit = new EventEmitter();

  constructor(private router: Router, private authService: AuthService, private invoiceService: InvoiceService) { }

  ngOnInit(): void {
    this.loading = false;
    this.title = "Últimas 6 facturas";
    this.numInvoices = 6;
    this.document = this.authService.getCurrentUser().document;
    this.getInvoiceByDocument();
  }

  getInvoiceByDocument() {
    this.loading = true;
    return this.invoiceService
    .getInvoiceByDocumentSrv(this.document, this.numInvoices)
    .subscribe(
      data => {
        this.invoiceChartData = data.result;
        this.loading = false;
        this.setArrayMonths(this.invoiceChartData);
        this.chartSelectedEmit.emit(this.invoiceChartData[this.invoiceChartData.length - 1]);
      },
      error => {
        console.log(error);
        this.loading = false;
        this.notification = new Notification(Notification.Type().Error, "", false);
      }
    );
  }

  private setArrayMonths(data:any){
    var utils = new Utils();
    let month:string;
    let importsLabel:Array<number> = new Array();
    let monthLabel:Array<string> = new Array();
    let totalImport:number;

    data.forEach(function (invoiceDocument) {

      totalImport = 0;
      invoiceDocument.invoices.forEach(function (invoice) {
        totalImport += invoice.totalAmount;
      });

      month = utils.getMonthByNumber(new Date(invoiceDocument.invoiceDate));

      monthLabel.push(month);
      importsLabel.push(+totalImport.toFixed(2));
    });

    importsLabel.push(0);

    this.monthLabel = monthLabel;
    this.chartDatasets[0].data = importsLabel;
  }

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 2,
    }
  ]

  public chartOptions: any = {
    responsive: true
  }

  public chartClicked(e: any): void {
    let currentInvoice:any;
    if(e.active && e.active.length > 0 && this.invoiceChartData){
      currentInvoice = this.invoiceChartData[e.active[0]._index];
      if(this.router.url.includes('/lines-dashboard')){
        this.router.navigate(['/invoices', currentInvoice.id]);
      }else if(this.router.url.includes('/invoices')){
        this.chartSelectedEmit.emit(currentInvoice);
      }
    }
  }

}