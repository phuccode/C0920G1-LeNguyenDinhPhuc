import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../customer-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  formCustomer: FormGroup;
  customerType: any = [];

  constructor(private fb: FormBuilder, private customerService : CustomerServiceService,
              private router: ActivatedRoute, private route: Router) { }

    // newCustomer = new FormGroup({
    //     id: new FormControl(['']) ,
    //     makhachhang: new  FormControl(['']),
    //     ten: new  FormControl(['',Validators.required, Validators.pattern('[A-Z a-z]+')]),
    //     ngaymoso: new  FormControl(['']),
    //     batdau: new  FormControl(['']),
    //     kihan: new FormControl(['']),
    //     sotiengui: new  FormControl(['']),
    //     laisuat: new  FormControl(['']),
    //     uudai: new  FormControl([''])
    //   });


  ngOnInit(): void {
    // this.formCustomer = this.fb.group({
    //         id: new FormControl(['']) ,
    //         makhachhang: new  FormControl(['']),
    //         ten: new  FormControl(['']),
    //         ngaymoso: new  FormControl(['']),
    //         batdau: new  FormControl(['']),
    //         kihan: new FormControl(['']),
    //         sotiengui: new  FormControl(['']),
    //         laisuat: new  FormControl(['']),
    //         uudai: new  FormControl([''])
    //       });
    // this.getCustomerType();
    // const studentId = Number(this.router.snapshot.params.id);
    // console.log(studentId);
    // this.customerService.getCustomer(studentId).subscribe(data => {
    //   console.log(data);
    //   this.formCustomer.setValue(data);
    // });
    // console.log(this.formCustomer)
  }

  // putEditCustomer() {
  //   // this.formCustomer = this.newCustomer;
  //   this.customerService.editCustomer(this.router.snapshot.params.id, this.formCustomer.value).subscribe(data => {
  //     this.route.navigateByUrl('/customer')
  //   })
  // }
  //
  // getCustomerType(){
  //   this.customerService.getAllCustomerType().subscribe((result) => {
  //     this.customerType = result;
  //     console.log(result);
  //   })
  // }
}
