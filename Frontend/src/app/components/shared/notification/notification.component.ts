import { Component, OnInit, Input } from '@angular/core';
import { Notification } from '../../../models/Notification.class';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  @Input() notification: Notification;

  constructor() { }

  ngOnInit(): void {

  }

  close(){
    this.notification = null;
  }

}