create database bai_tap_them;
use bai_tap_them;
create table categories(
id int ,
name nvarchar(50),
description nvarchar(500)
);

create table suppliers(
id int,
name nvarchar(100),
email varchar(50),
phone varchar(50),
address nvarchar(500)
);

create table customer(
id varchar(50),
firstname nvarchar(50),
lastname nvarchar(50),
phonenumber varchar(50),
address nvarchar(500),
email varchar(50),
birthday date
);

CREATE TABLE bai_tap_them.employees (
  id VARCHAR(50),
  firstname NVARCHAR(50) ,
  lastname NVARCHAR(55) ,
  phonenumber  NVARCHAR(55) ,
  address NVARCHAR(500) ,
  email VARCHAR(50) ,
  birthday DATE 
  );

CREATE TABLE bai_tap_them.products (
  id INT  ,
  name NVARCHAR(50) ,
  umageurl NVARCHAR(1000) ,
  price INT ,
  discount INT ,
  stock INT 
  );
  
  CREATE TABLE bai_tap_them.orders (
  id INT ,
  createddate DATETIME NULL,
  shippeddate DATETIME NULL,
  status VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  shippingaddress NVARCHAR(500) NULL,
  shippingcity NVARCHAR(50) NULL,
  paymenttype VARCHAR(20) NULL,
  customerid VARCHAR(50) NULL,
  employeeid VARCHAR(50) NULL
  );
	
    
CREATE TABLE bai_tap_them.orderdetails (
id INT ,
orderid INT ,
productid INT ,
quantity INT 
);
  