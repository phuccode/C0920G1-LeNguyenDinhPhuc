use case_study;
-- Thêm cột tuổi vào bảng khách hàng
alter table khachhang
add tuoi int 
after ngay_sinh;
-- thêm dữ liệu vào các ô mới được tạo
update khachhang
set tuoi = 21
where id_khach_hang = 1;

update khachhang
set tuoi = 21
where id_khach_hang = 2;

update khachhang
set tuoi = 21
where id_khach_hang = 3;

update khachhang
set tuoi = 17
where id_khach_hang = 4;

update khachhang
set tuoi = 55
where id_khach_hang = 5;

-- task 2 --
select ho_ten from nhanvien
 where ho_ten 
 like 'h%' or ho_ten like 'k%' or ho_ten like 't%';
 
 -- task 3 --
 select * from khachhang 
 where (tuoi >= 18 and tuoi <= 50) and (dia_chi = 'đà nẵng' or dia_chi = 'quảng trị');
 
 -- task 4
 