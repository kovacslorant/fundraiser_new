import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AccountService} from "../../services/account.service";
import {CreateAccountCommandModel} from "../../models/create-account-command.model";

@Component({
  selector: 'app-account-registration',
  templateUrl: './account-registration.component.html',
  styleUrls: ['./account-registration.component.css']
})
export class AccountRegistrationComponent implements OnInit{
  registerForm!: FormGroup
  constructor(private formBuilder:FormBuilder,
              private accountService:AccountService) {
    this.registerForm = this.formBuilder.group({
      username:['', Validators.required],
      goal: ['', Validators.required]
    })
  }

  ngOnInit(): void {

  }


  register() {
    const formData: CreateAccountCommandModel = this.registerForm.value;
    this.accountService.registerAccount(formData).subscribe({
      error:err => console.error(err),
      complete: () => this.registerForm.reset()
    })
  }
}
