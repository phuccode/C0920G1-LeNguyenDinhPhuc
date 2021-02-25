import { Injectable } from '@angular/core';
import {Customer} from './customer';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http: HttpClient) {
  }

  // findById(customerId: number): Customer{
  //   const customerList = [];
  //   customerList.push(1, 1, 'Phuc', '11-11-1996', '12345689', '123', 'phuc@gmail.com', 'DanNang');
  //   customerList.push(2, 1, 'Anh', '11-11-1996', '12345689', '456', 'anh@gmail.com', 'DanNang');
  //   customerList.push(3, 1, 'Chien', '11-11-1996', '12345689', '789', 'chien@gmail.com', 'DanNang');
  //
  //   return customerList.find(customerObj => customerObj.id === customerId);
  // }

  createCustomer(customer){
    return this.http.post('http://localhost:3000/customerList', customer);
  }
  getAllCustomer(){
    return this.http.get('http://localhost:3000/customerList')
  }
  editCustomer(){

  }
  deleteCustomer(customer){
    return this.http.delete('http://localhost:3000/customerList'+ '/' + customer)
  }

}
