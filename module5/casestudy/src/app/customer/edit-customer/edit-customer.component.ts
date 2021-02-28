import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {CustomerServiceService} from "../customer-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  formCustomer: FormGroup;

  constructor(private fb: FormBuilder, private customerService : CustomerServiceService,
              private router: ActivatedRoute, private route: Router) { }

    editCustomer = new FormGroup({
      id: new FormControl(['']) ,
      idCustomerType: new  FormControl(['']),
      name: new  FormControl(['']),
      dateOfBirth: new  FormControl(['']),
      CMND: new  FormControl(['']),
      phone: new FormControl(['']),
      email: new  FormControl(['']),
      address: new  FormControl([''])
    });

  ngOnInit(): void {
    const studentId = Number(this.router.snapshot.params.id);
    console.log(studentId);
    this.customerService.getCustomer(studentId).subscribe(data => {
      console.log(data);
      this.editCustomer.setValue(data);
    });
  }

  putEditCustomer() {
    this.customerService.editCustomer(this.router.snapshot.params.id, this.editCustomer.value).subscribe(data => {
      this.route.navigateByUrl('/customer')
    })
  }

}
