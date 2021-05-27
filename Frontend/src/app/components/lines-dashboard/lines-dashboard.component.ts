import { Component, OnInit, ɵConsole } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { ClientmanagementService } from '../../services/clientmanagement.service';

@Component({
  selector: 'app-lines-dashboard',
  templateUrl: './lines-dashboard.component.html',
  styleUrls: ['./lines-dashboard.component.css']
})
export class LinesDashboardComponent implements OnInit {

  public loading:boolean;

  constructor(public authService: AuthService, private clientmanagementService: ClientmanagementService) { 
    this.loading = true;
  }

  ngOnInit(): void {
    this.getClientManagementData();
    this.loading = false;
  }

  getClientManagementData() {
    if(this.authService.getCurrentUser()) {
      return this.clientmanagementService
      .getClientByDocument(this.authService.getCurrentUser().document)
      .subscribe(
        data => {
          sessionStorage.setItem('clientManagementData', JSON.stringify(data.result));
        },
        error => {
          console.log(error);
        }
      );
    }
  }
  
}