import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { map } from "rxjs/operators";
import { API } from '../../environments/environment';
import { Client } from '../models/Client.class';

@Injectable({
  providedIn: 'root'
})
export class ClientmanagementService {

  constructor(private http: HttpClient) { }

  headers: HttpHeaders = new HttpHeaders({
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*"
  });

  getClientByDocument(document:string): Observable<any> {
    const url = API.msclientmanagementv1 + "document/" + document;
    return this.http
      .get(
        url,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

  updateClient(client: Client): Observable<any> {
    const url = API.msclientmanagementv1 + "updateClient";
    return this.http
      .post<String>(
        url,
        client,
        { headers: this.headers }
      )
    .pipe(map(data => data));
  }

}