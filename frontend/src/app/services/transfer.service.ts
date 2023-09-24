import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TransferInitDataModel} from "../models/transfer-init-data.model";

const BASE_URL = "http://localhost:8080/api/transfers"

@Injectable({
  providedIn: 'root'
})
export class TransferService {

  constructor(private http :HttpClient) { }

  getNewTransferInitData(): Observable<TransferInitDataModel>{
    return this.http.get<TransferInitDataModel>(BASE_URL + "/newTransfer");
  }

}
