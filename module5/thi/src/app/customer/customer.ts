import {CustomerType} from "../customer-type";

export class Customer{
  id: number;
  idCustomerType: CustomerType;
  name: string;
  dateOfBirth: string;
  CMND: string;
  phone: string;
  email: string;
  address: string;

  constructor(id: number, idCustomerType: CustomerType, name: string, dateOfBirth: string,
              CMND: string, phone: string, email: string, address: string) {
    this.id = id;
    this.idCustomerType = idCustomerType;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.CMND = CMND;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }
}
