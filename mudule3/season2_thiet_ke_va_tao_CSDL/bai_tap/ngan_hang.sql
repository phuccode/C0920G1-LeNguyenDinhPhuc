create database acount_bank; 
use acount_bank;
create table Customers (
customer_number int primary key,
fullname char(23),
address  char(23),
email  char(23),
phone int
);
create table Accounts (
account_number int primary key,
account_type char(55),
date date,
balance int,
customer_number int, 
FOREIGN KEY (customer_number) REFERENCES Customers(customer_number)
);
create table Transactions (
tran_number int primary key,
account_number int,
date date,
amounts int,
descriptions char(255),
FOREIGN KEY (account_number) REFERENCES Accounts(account_number)
);
select*from Accounts;