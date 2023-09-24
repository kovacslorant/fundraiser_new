import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateAccountCommandModel} from "../models/create-account-command.model";

const BASE_URL = 'http://localhost:8080/api/accounts'
@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http:HttpClient) { }

  registerAccount(data: CreateAccountCommandModel): Observable<any>{
    return this.http.post(BASE_URL, data);
  }

}
