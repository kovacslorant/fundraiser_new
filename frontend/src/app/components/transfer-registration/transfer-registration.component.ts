import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TransferService} from "../../services/transfer.service";
import {TransferInitDataModel} from "../../models/transfer-init-data.model";

@Component({
  selector: 'app-transfer-registration',
  templateUrl: './transfer-registration.component.html',
  styleUrls: ['./transfer-registration.component.css']
})
export class TransferRegistrationComponent implements OnInit{

  transferForm!: FormGroup
  newTransferData!: TransferInitDataModel;
  constructor(private formBuilder:FormBuilder,
              private transferService: TransferService) {
    this.transferForm = this.formBuilder.group({
      target: ['', Validators.required],
      amount: ['', [Validators.required, Validators.min(50), Validators.max(1000)]],
    })
  }

  ngOnInit(): void {
    this.transferService.getNewTransferInitData().subscribe({
      next: data => this.newTransferData = data,
      error: err => console.error(err)
    })
  }


  sendTransfer() {

  }
}
