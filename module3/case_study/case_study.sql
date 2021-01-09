drop database if exists case_study;
create database case_study;
use case_study;

-- task 1 --
create table loaikhach (
  id_loai_khach int ,
  ten_loai_khach varchar(45) ,
  primary key (id_loai_khach));

insert into loaikhach value (1, 'Diamond'), (2, 'Platinium')
, (3, 'Gold'), (4, 'Silver'), (5,'Member');
select * from loaikhach;

create table khachhang (
  id_khach_hang int ,
  id_loai_khach int ,
  ho_ten_khach_hang varchar(45) ,
  ngay_sinh date ,
  so_CMND varchar(45) ,
  SDT_kh varchar(45) ,
  email varchar(45) ,
  dia_chi varchar(45) ,
  primary key (id_khach_hang),
  foreign key (id_loai_khach) references loaikhach(id_loai_khach)
  );
  
  insert into khachhang value (1,1,'Phúc Lê', '1999-11-11', '123', '123' , 'aaa','Đà Nẵng'),
  (2,1,'Thế Anh', '2007-11-11', '234', '123' , 'aaa','Quảng Ngãi'),
  (3,1,'Minh Chiến', '1999-11-11', '345', '223' , 'bbb','Đà Nẵng'),
  (4,4,'Hiếu','2010-11-11', '111', '567' , 'ccc','Huế'),
  (5,5,'Phước', '1999-11-11', '222', '789' , 'ddd','Hà Nội');
  select * from khachhang;
  
  create table kieuthue (
  id_kieu_thue int  ,
  ten_kieu_thue varchar(45) ,
  gia int ,
  primary key (id_kieu_thue)
  );
  
  insert into kieuthue value (1, '1 ngày', 100),
  (2, '2 ngày', 200),
  (3, '3 ngày', 300),
  (4, '4 ngày', 400),
  (5, '5 ngày', 500),
  (6, 'tháng', 2000);
  select * from kieuthue;
  
  create table loaidichvu(
  id_loai_dich_vu int primary key,
  ten_loai_dich_vu varchar(45)
  );
  
  insert into loaidichvu value (1,'villa1'),
  (2,'villa2'),
  (3,'house1'),
  (4,'room1'),
  (5,'room2');
  
  select * from loaidichvu;
  
  create table dichvu(
  id_dich_vu int,
  ten_dich_vu varchar(45),
  dien_tich int,
  so_tang int,
  so_nguoi_toi_da varchar(45),
  chi_phi_thue varchar(45),
  id_kieu_thue int,
  id_loai_dich_vu int,
  trang_thai varchar(45),
  primary key (id_dich_vu),
  foreign key (id_kieu_thue) references kieuthue(id_kieu_thue),
  foreign key (id_loai_dich_vu) references loaidichvu(id_loai_dich_vu)
  );
  
  insert into dichvu value(1, 'Villa' , 34, 3, 4, 500, 1 , 1, 'đã thuê'),
  (2, 'House' , 32, 3, 4, 500, 2 , 3, 'được thuê'),
  (3, 'Room' , 31, 3, 4, 500, 3 , 2, 'được thuê'),
  (4, 'Villa' , 34, 3, 4, 500, 4 , 4, 'đã thuê'),
  (5, 'House' , 33, 3, 4, 500, 5 , 5, 'được thuê');
  
  select * from dichvu;
  
create table vitri(
  id_vi_tri int primary key,
  ten_vi_tri varchar(45)
  );
  
  insert into vitri value (1, 'Lễ tân'),
  (2, 'phục vụ'),
  (3, 'chuyên viên'),
  (4, 'giám sát'),
  (5, 'quản lý'),
  (6, 'giám đốc');
  select * from vitri; 
  
  create table trinhdo(
  id_trinh_do int primary key,
  trinh_do varchar(45)
  );
  
   insert into trinhdo value (1, 'Cao Đẳng'),
  (2, 'Đại Học'),
  (3, 'Trung Cấp'),
  (4, 'Sau Đại Học');
  select * from trinhdo;
  
  create table bophan(
  id_bo_phan int primary key,
  ten_bo_phan varchar(45)
  );
 
    insert into bophan value (1, 'Sale – Marketing'),
  (2, 'Hành Chính'),
  (3, 'Phục vụ'),
  (4, 'Quản lý');
 select * from bophan;
 
  create table nhanvien(
  id_nhan_vien int primary key,
  ho_ten_nhan_vien varchar(45),
  id_vi_tri int,
  id_trinh_do int,
  id_bo_phan int,
  ngay_sinh date,
  so_CMND varchar(45),
  luong varchar(45),
  SDT_nv varchar(45),
  email varchar(45),
  dia_chi varchar(45),
  foreign key (id_vi_tri) references vitri(id_vi_tri),
  foreign key (id_trinh_do) references trinhdo(id_trinh_do),
  foreign key (id_bo_phan) references bophan(id_bo_phan)
  );
  
  insert into nhanvien value (1, 'Anh', 1, 1, 1, '2000-12-12', '111', '6000', '123', 'aaa', '11 aaa'),
  (2, 'Chiến', 2, 2, 2, '1999-12-12', '111', '6000', '123', 'aaa', '11 aaa'),
  (3, 'Hiếu', 3, 3, 3, '1998-12-12', '111', '6000', '123', 'aaa', '11 aaa'),
  (4, 'Hưng', 4, 4, 4,'1997-12-12', '111', '6000', '123', 'aaa', '11 aaa'),
  (5, 'Khánh', 5, 4, 4,'1994-12-12', '111', '6000', '123', 'aaa', '11 aaa'),
  (6, 'Phúc', 6, 2, 2,'1998-12-12', '111', '6000', '123', 'aaa', '11 aaa');
  select * from nhanvien;
  
   create table hopdong(
  id_hop_dong int primary key,
  id_nhan_vien int,
  id_khach_hang int,
  id_dich_vu int,
  ngay_lam_hop_dong date,
  ngay_ket_thuc date,
  tien_dat_coc int,
  tong_tien int,
  foreign key (id_nhan_vien) references nhanvien(id_nhan_vien),
  foreign key (id_khach_hang) references khachhang(id_khach_hang),
  foreign key (id_dich_vu) references dichvu(id_dich_vu)
  );
  alter table hopdong drop column tong_tien;
  insert into hopdong value(1,1,1,1,'2020-12-12','2020-12-22',200),
  (2,2,2,2,'2018-12-12','2018-12-22',500),
  (3,3,3,3,'2017-12-12','2017-12-22',200),
  (4,4,4,4,'2020-12-23','2020-12-24',200),
   (5,3,3,3,'2018-12-12','2018-12-22',200),
   (6,3,3,3,'2019-12-12','2020-12-22',200),
   (7,3,3,3,'2020-12-12','2020-12-22',200),
	(8,4,4,4,'2019-08-12','2020-12-22',200),
    (9,4,4,4,'2018-09-12','2018-09-13',200)
  ;
  select * from hopdong;
create table dichvudikem(
id_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45),
primary key (id_dich_vu_di_kem)
);  

insert into dichvudikem value (1,'massage',200,2,'còn hàng'),
(2,'karaoke',100,3,'còn hàng'),
(3,'thức ăn',50,4,'còn hàng'),
(4,'nước uống',20,5,'hết hàng'),
(5,'thuê xe',150,6,'hết hàng');
select * from dichvudikem;

create table hopdongchitiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,	
so_luong int,
foreign key (id_hop_dong) references hopdong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dichvudikem(id_dich_vu_di_kem)
); 

insert into hopdongchitiet value (1,1,1,1),
(2,2,2,2),
(3,3,3,2),
(4,4,4,3),
(5,4,5,2);
select * from hopdongchitiet;