import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AccountRegistrationComponent} from "./components/account-registration/account-registration.component";
import {AccountListComponent} from "./components/account-list/account-list.component";

const routes: Routes = [
  {path: 'account-registration', component: AccountRegistrationComponent},
  {path: 'accounts',component:AccountListComponent},
  {path: '',  component:AccountListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
