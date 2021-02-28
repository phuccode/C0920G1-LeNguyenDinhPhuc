import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";

import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule} from "@angular/forms";

const routes: Routes = [
  {path: '', redirectTo: 'customer', pathMatch: 'full'},
  {path: 'customer', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule
  ]
})
export class CustomerRoutingModule { }
