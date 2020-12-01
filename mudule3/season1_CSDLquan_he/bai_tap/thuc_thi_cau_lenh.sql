create database classicmodels;
use classicmodels;
create table customer(
cusname char(255),
phone int (10),
city char(50),
country char(50)
);

insert into customer value ('Phúc', 1, 'Đà Nẵng', 'Việt Nam');
select*from customer;
insert into customer value ('Anh', 2, 'Đà Nẵng', 'Việt Nam');
select*from customer where cusname = 'Anh';
select*from customer where cusname like '%A%';
select * from customer where country in ('Việt Nam');