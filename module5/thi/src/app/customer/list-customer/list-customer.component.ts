import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from "../customer-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerList: any = [];
  curPage =  1;
  term: any;

  constructor(private customerService: CustomerServiceService, private router: Router) {
    this.customerList = this.findAll();
    console.log(this.customerList);
  }

  ngOnInit(): void {
  }

  findAll(){
    this.customerService.getAllCustomer().subscribe((result) => {
      this.customerList = result;
    })
  }

  deleteCustomer(customer){
    this.customerService.deleteCustomer(customer).subscribe(() =>{
      this.customerService.getAllCustomer();
      this.router.navigateByUrl('/customer')
    })
  }

}
