import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginGuard } from './components/auth/guards/login.guard';
import { LogoutGuard } from './components/auth/guards/logout.guard';
import { LoginComponent }      from './components/auth/login/login.component';
import { LinesDashboardComponent }      from './components/lines-dashboard/lines-dashboard.component';
import { ConsumptionComponent }      from './components/consumption/consumption.component';
import { InvoicesComponent }      from './components/invoices/invoices.component';
import { LineservicesComponent }      from './components/lineservices/lineservices.component';
import { SettingsComponent }      from './components/settings/settings.component';
import { DocumentationComponent }      from './components/shared/documentation/documentation.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate:[LogoutGuard] },
  { path: 'lines-dashboard', component: LinesDashboardComponent, canActivate:[LoginGuard] },
  { path: 'consumption', component: ConsumptionComponent, canActivate:[LoginGuard] },
  { path: 'consumption/:phone', component: ConsumptionComponent, canActivate:[LoginGuard] },
  { path: 'invoices', component: InvoicesComponent, canActivate:[LoginGuard] },
  { path: 'invoices/:id', component: InvoicesComponent, canActivate:[LoginGuard] },
  { path: 'lineservices', component: LineservicesComponent, canActivate:[LoginGuard] },
  { path: 'lineservices/:phone', component: LineservicesComponent, canActivate:[LoginGuard] },
  { path: 'settings', component: SettingsComponent, canActivate:[LoginGuard] },
  { path: 'documentation', component: DocumentationComponent, canActivate:[LoginGuard] },
  { path: '**', pathMatch: 'full', redirectTo: 'lines-dashboard' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
  providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy }]
})
export class AppRoutingModule { }