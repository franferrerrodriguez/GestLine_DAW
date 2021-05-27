import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.css']
})
export class InvoicesComponent implements OnInit {

  public loading:boolean;
  public currentInvoice:number;
  public chartSelected:any;

  constructor() {
    this.loading = true;
  }

  ngOnInit(): void {
    setTimeout(() => {
      this.loading = false;
    }, 500);
  }

  setChartSelected($event) {
    this.chartSelected = $event;
  }

}