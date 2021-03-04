import {CustomerType} from "../customer-type";

export class Customer{
  id: number;
  name: string;
  email: string;
  phone: string;
  address: string;


  constructor(id: number, name: string, email: string, phone: string, address: string) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
  }
}
