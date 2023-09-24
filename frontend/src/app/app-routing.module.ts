import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AccountRegistrationComponent} from "./components/account-registration/account-registration.component";
import {AccountListComponent} from "./components/account-list/account-list.component";
import {TransferRegistrationComponent} from "./components/transfer-registration/transfer-registration.component";
import {AccountDetailsComponent} from "./components/account-details/account-details.component";


const routes: Routes = [
  {path: 'account-registration', component: AccountRegistrationComponent},
  {path: 'accounts',component:AccountListComponent},
  {path: 'transfer-registration',component:TransferRegistrationComponent},
  {path: 'my-account',component:AccountDetailsComponent},
  {path: '',  component:AccountListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
