drop database if exists case_study;
create database case_study;
use case_study;

CREATE TABLE loaikhach (
  id_loai_khach INT ,
  ten_loai_khach VARCHAR(45) ,
  PRIMARY KEY (id_loai_khach));

CREATE TABLE khachhang (
  id_khach_hang INT ,
  id_loai_khach INT ,
  ho_ten VARCHAR(45) ,
  ngay_sinh DATE ,
  so_CMND VARCHAR(45) ,
  SDT VARCHAR(45) ,
  email VARCHAR(45) ,
  dia_chi VARCHAR(45) ,
  PRIMARY KEY (id_khach_hang),
  FOREIGN kEY (id_loai_khach) REFERENCES loaikhach(id_loai_khach)
  );
  
  CREATE TABLE kieuthue (
  id_kieu_thue INT  ,
  ten_kieu_thue VARCHAR(45) ,
  gia INT ,
  PRIMARY KEY (id_kieu_thue)
  );
  
  CREATE TABLE loaidichvu(
  id_loai_dich_vu int primary key,
  ten_loai_dich_vu VARCHAR(45)
  );
  
  CREATE TABLE dichvu(
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
  
CREATE TABLE vitri(
  id_vi_tri int primary key,
  ten_vi_tri VARCHAR(45)
  );
  
  CREATE TABLE trinhdo(
  id_trinh_do int primary key,
  trinh_do VARCHAR(45)
  );
  
  CREATE TABLE bophan(
  id_bo_phan int primary key,
  ten_bo_phan VARCHAR(45)
  );
 
  CREATE TABLE nhanvien(
  id_nhan_vien int primary key,
  ho_ten VARCHAR(45),
  id_vi_tri int,
  id_trinh_do int,
  id_bo_phan int,
  ngay_sinh date,
  so_CMND VARCHAR(45),
  luong VARCHAR(45),
  SDT VARCHAR(45),
  email VARCHAR(45),
  dia_chi VARCHAR(45),
  foreign key (id_vi_tri) references vitri(id_vi_tri),
  foreign key (id_trinh_do) references trinhdo(id_trinh_do),
  foreign key (id_bo_phan) references bophan(id_bo_phan)
  );
  
   CREATE TABLE hopdong(
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
  
create table dichvudikem(
id_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45),
primary key (id_dich_vu_di_kem)
);  

create table hopdongchitiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,	
so_luong int,
foreign key (id_hop_dong) references hopdong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dichvudikem(id_dich_vu_di_kem)
);  
  
  