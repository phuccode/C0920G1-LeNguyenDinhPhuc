drop database if exists case_study_jsp_servlet;
create database case_study_jsp_servlet;
use case_study_jsp_servlet;

create table `position`(
	position_id int primary key auto_increment,
    position_name varchar(45)
);

insert into `position` value (1,'Lễ Tân');
insert into `position` value (2,'Phục Vụ') , (3,'Chuyên Viên') , (4,'Giám Sát'), (5,'Quản Lý')
, (6,'Giám Đốc');

create table education_degree(
	education_degree_id int primary key auto_increment,
	education_degree_name varchar(45)
);

insert into education_degree value (1,'Trung Cấp') , (2,'Cao Đẳng'), (3,'Đại Học')
, (4,'Sau Đại Học');

create table division(
	division_id int primary key auto_increment,
    division_name varchar(45)
);

insert into division value (1,'Sale-Marketing') , (2,'Hành Chính'), (3,'Phục vụ')
, (4,'Quản lý');

create table role(
	role_id int primary key auto_increment,
    role_name varchar(255)
);

create table user(
	user_name varchar(255) primary key,
    password varchar(255)
);

insert into user value ('Phuc','123');

create table user_role(
	role_id int,
    user_name varchar(255),
	foreign key (role_id) references role(role_id),
    foreign key (user_name) references user(user_name)
);

create table attach_service(
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45)
);

insert into attach_service value (1,'massage',100,3,'Còn Hàng') , (2,'karaoke',50,3,'Còn Hàng') ,
(3,'food',20,3,'Còn Hàng') ,(4,'drink',10,3,'Còn Hàng') ,(5,'car',200,3,'Còn Hàng');

create table customer_type(
	customer_type_id int primary key,
    customer_type_name varchar(45)
);

insert into customer_type value (1,'Vip Pro');

create table service_type(
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

insert into service_type value (1,'Vip'), (2,'Vip2'), (3,'Vip3');

create table rent_type(
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);

insert into rent_type value (1,'năm',1000), (2,'tháng', 300), (3,'ngày', 20);

create table customer(
	customer_id int primary key auto_increment,
    customer_type_id int,
    customer_name varchar(45),
    customer_birthday date,
    customer_gender varchar(45),
    customer_id_card varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    foreign key (customer_type_id) references customer_type(customer_type_id)
);

INSERT INTO customer (customer_id, customer_type_id, 
customer_name, customer_birthday, customer_gender,
 customer_id_card, customer_phone, customer_email,
 customer_address) VALUE (1, 1, 'Phúc', '1998-11-11', 'Male', '123', '234', 'phuc@gmail', '123 ABC');
 INSERT INTO customer (customer_id,customer_type_id, 
customer_name, customer_birthday, customer_gender,
 customer_id_card, customer_phone, customer_email,
 customer_address) VALUE (2,1,'Phúc', '1998-11-11', 'Male', '123', '234', 'phuc@gmail', '123 ABC');


create table service(
	service_id int primary key auto_increment,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    foreign key (rent_type_id) references rent_type(rent_type_id),
    foreign key (service_type_id) references service_type(service_type_id)
);

create table employee(
	employee_id int primary key auto_increment,
    employee_name varchar(45),
    employee_birthday date,
    employee_id_card varchar(45),
    employee_salary double,
    employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    user_name varchar(255),
    foreign key (position_id) references `position`(position_id),
    foreign key (education_degree_id) references education_degree(education_degree_id),
    foreign key (division_id) references division(division_id),
    foreign key (user_name) references user(user_name)
);

INSERT INTO employee (employee_id,employee_name, employee_birthday, employee_id_card, 
employee_salary, employee_phone, employee_email,employee_address,position_id,education_degree_id,
 division_id, user_name) VALUE 
(1, 'Anh', '1999-11-11', '222', 1.0, '1111', 'anhml@gmail.com', '11 aa', 1, 1, 1, 'phuc');

create table contract(
	contract_id int primary key auto_increment,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id int,
    service_id int,
    foreign key (employee_id) references employee(employee_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (service_id) references service(service_id)
);

insert into contract value (1,'1111-11-11','1111-11-11',1,1,1,1,1);
select * from contract;

create table contract_detail(
	contract_detail_id int primary key auto_increment,
    contract_id int,
    attach_service_id int,
    quantity int,
    foreign key (contract_id) references contract(contract_id),
    foreign key (attach_service_id) references attach_service(attach_service_id)
);

insert into contract_detail value (1,2,2,1);

DELIMITER //
CREATE PROCEDURE search_customer(
in customer_name VARCHAR(45)
)
BEGIN
	SELECT * FROM customer WHERE customer.customer_name LIKE concat('%',customer_name ,'%');
END//
DELIMITER ;

DROP PROCEDURE search_customer;

DELIMITER //
CREATE PROCEDURE search_employee(
in employee_name VARCHAR(45)
)
BEGIN
	SELECT * FROM employee WHERE employee.employee_name LIKE concat('%',employee_name ,'%');
END//
DELIMITER ;
