import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from '../customer-service.service';
import {FormBuilder, FormControl, FormControlName, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  formCustomer: FormGroup;
  allCustomer: Object;
  constructor(private customerService: CustomerServiceService,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getLatestCustomer();
    this.formCustomer = this.fb.group({
      id:[''],
      idCustomerType: [''],
      name: [''],
      dateOfBirth: [''],
      CMND: [''],
      phone: [''],
      email: [''],
      address: ['']
    });
  }

  addCustomer(fromObj){
    console.log(fromObj);
    this.customerService.createCustomer(fromObj).subscribe((response) => {
      // console.log('Hello')
      this.getLatestCustomer();
    });
  }

  getLatestCustomer() {
    this.customerService.getAllCustomer().subscribe((response) => {
      this.allCustomer = response;
    })
  }
}
