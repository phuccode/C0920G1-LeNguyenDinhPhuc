create database study;
use study;
create table manager_student(
id int,
ten char(50),
tuoi int,
khoa_hoc varchar(45),
so_tien int
);

insert into manager_student value (1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(5,'Huong',20,'TCNH',200000)
;

-- hiển thị tất cả các dòng tên hương
select * from manager_student where ten = 'Huong';
 -- lấy ra tổng số tiền của Huong
select ten, sum(so_tien) as tong_tien from manager_student where ten = 'Huong';
-- lấy ra tên danh sách của tất cả học viên, không trùng lặp
select distinct id, ten from  manager_student;

