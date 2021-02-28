import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from '../customer-service.service';
import {FormBuilder, FormControl, FormControlName, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  formCustomer: FormGroup;
  constructor( private router: Router, private customerService: CustomerServiceService,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.formCustomer = this.fb.group({
      id:[''],
      idCustomerType: [''],
      name: ['', [Validators.required, Validators.pattern('[A-Za-z]+')]],
      dateOfBirth: [''],
      CMND: [''],
      phone: ['', [Validators.required, Validators.pattern('[0-9]+')]],
      email: [''],
      address: ['']
    });
  }

  addCustomer(fromObj){
    console.log(fromObj);
    this.customerService.createCustomer(fromObj).subscribe((response) => {
      this.router.navigateByUrl('/customer')
    });
  }

}
