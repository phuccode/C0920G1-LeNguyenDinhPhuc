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
  // formCustomer: FormGroup;
  // customerType: any = [];
  constructor( private router: Router, private customerService: CustomerServiceService,private fb: FormBuilder) {

  }

  ngOnInit(): void {
    // this.getCustomerType();
    // this.formCustomer = this.fb.group({
    //   id:[''],
    //   idCustomerType: [''],
    //   name: ['', [Validators.required, Validators.pattern('[A-Za-z]+')]],
    //   dateOfBirth: ['', [Validators.required]],
    //   CMND: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
    //   phone: ['', [Validators.required, Validators.pattern('^(090|091|([\\(]84[\\)][\\+]90)|([\\(]84[\\)][\\+]91))[0-9]{7}$')]],
    //   email: ['', [Validators.required, Validators.email]],
    //   address: ['', [Validators.required, Validators.pattern('[A-Za-z]+')]]
    // });
  }

  // addCustomer(fromObj){
  //   console.log(fromObj);
  //   this.customerService.createCustomer(fromObj).subscribe((response) => {
  //     this.router.navigateByUrl('/customer')
  //   });
  // }
  //
  // getCustomerType(){
  //   this.customerService.getAllCustomerType().subscribe((result) => {
  //     this.customerType = result;
  //     console.log(result);
  //   })
  // }
}
