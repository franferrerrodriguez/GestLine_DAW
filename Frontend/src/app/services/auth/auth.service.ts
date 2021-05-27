import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { map } from "rxjs/operators";
import { User } from '../../models/user.class';
import { Client } from '../../models/client.class';
import { environment, API } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  headers: HttpHeaders = new HttpHeaders({
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*"
  });

  loginUser(user: User): Observable<any> {
    const url = API.msauthenticationv1 + "checkLogin";
    return this.http
      .post<User>(
        url,
        user,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

  updateUser(user: User): Observable<any> {
    const url = API.msauthenticationv1 + "updateUser";
    return this.http
      .post<User>(
        url,
        user,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

  getBlackList(document: string): Observable<any> {
    const url = API.msauthenticationv1 + "getBlackList/" + document;
    return this.http
      .get<Boolean>(
        url,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }
  
  setUser(user: User): void {
    let user_string = JSON.stringify(user);
    sessionStorage.setItem("currentUser", user_string);
  }

  setToken(token): void {
    sessionStorage.setItem("accessToken", token);
  }

  getToken():string {
    return sessionStorage.getItem("accessToken");
  }

  setSessionTime(): void {
    sessionStorage.setItem("sessionTime", new Date()
      .setMinutes(new Date()
      .getMinutes() + environment.sessionTime)
      .toString());
  }

  getSessionTime():number {
    return +sessionStorage.getItem("sessionTime");
  }

  refreshSessionTime(): void {
    this.checkSessionTime();
    if(this.getSessionTime())
      this.setSessionTime();
  }

  checkSessionTime() {
    if(this.getSessionTime() && new Date().getTime() > this.getSessionTime())
      this.logoutUser();
  }

  getTokenServer(document:string): Observable<any> {
    const url = API.msauthenticationv1 + "getToken/" + document;
    return this.http
      .get<string>(
        url,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

  getCurrentUser(): User {
    let user: any = sessionStorage.getItem("currentUser");
    if (user) {
      user = JSON.parse(user);
      return user;
    } else {
      return null;
    }
  }

  getClientManagementData(): Client {
    let clientManagementData: any = sessionStorage.getItem("clientManagementData");
    if (clientManagementData) {
      clientManagementData = JSON.parse(clientManagementData);
      return clientManagementData;
    } else {
      return null;
    }
  }

  logoutUser() {
    sessionStorage.removeItem("clientManagementData");
    sessionStorage.removeItem("accessToken");
    sessionStorage.removeItem("currentUser");
    sessionStorage.removeItem("sessionTime");
    window.location.reload();
  }

}