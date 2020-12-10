use case_study;
-- task 2 --
select ho_ten_nhan_vien from nhanvien
 where (ho_ten_nhan_vien 
 like 'h%' or ho_ten_nhan_vien like 'k%' or ho_ten_nhan_vien like 't%') 
 and char_length(ho_ten_nhan_vien) <= 15;
 
 -- task 3 --
select * from khachhang 
where year(curdate()) - year(ngay_sinh) > 18 
and year(curdate()) - year(ngay_sinh) < 50 
and dia_chi in ('Đà Nẵng', 'Quảng Trị');
 
 -- task 4 --
select khachhang.id_khach_hang , loaikhach.id_loai_khach , hopdong.cnt from khachhang 
join(select hopdong.id_khach_hang , count(hopdong.id_khach_hang) as cnt 
from hopdong group by id_khach_hang) hopdong
on khachhang.id_khach_hang = hopdong.id_khach_hang 
join loaikhach on khachhang.id_loai_khach  = loaikhach.id_loai_khach 
where khachhang.id_loai_khach  = 1 order by hopdong.cnt asc;
 
 -- task 5 --
select khachhang.id_khach_hang, khachhang.ho_ten_khach_hang,
hopdong.id_hop_dong,hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc,
dichvu.id_dich_vu, dichvu.ten_dich_vu, dichvudikem.gia,hopdongchitiet.so_luong,
dichvu.chi_phi_thue, (dichvudikem.gia * hopdongchitiet.so_luong) as tongtien 
from khachhang
left join hopdong
 on khachhang.id_khach_hang = hopdong.id_khach_hang
left join dichvu 
on hopdong.id_dich_vu = dichvu.id_dich_vu 
left join hopdongchitiet 
on hopdong.id_hop_dong = hopdongchitiet.id_hop_dong 
left join dichvudikem 
on hopdongchitiet.id_dich_vu_di_kem = dichvudikem.id_dich_vu_di_kem;
 
 -- task 6
 select dichvu.id_dich_vu, dichvu.ten_dich_vu, dichvu.dien_tich, dichvu.chi_phi_thue,
 loaidichvu.ten_loai_dich_vu, hopdong.ngay_ket_thuc
 from dichvu
 join loaidichvu on dichvu.id_loai_dich_vu = loaidichvu.id_loai_dich_vu
 join hopdong on dichvu.id_dich_vu = hopdong.id_dich_vu
where ((year(hopdong.ngay_ket_thuc) = 2019 
and month(hopdong.ngay_ket_thuc) < 4)  or (year(hopdong.ngay_ket_thuc) < 2019));
 

 -- task 7
  select dichvu.id_dich_vu, dichvu.ten_dich_vu,dichvu.dien_tich,dichvu.so_nguoi_toi_da,
 dichvu.chi_phi_thue, loaidichvu.ten_loai_dich_vu, hopdong.ngay_lam_hop_dong 
 from dichvu 
 join loaidichvu on dichvu.id_loai_dich_vu = loaidichvu.id_loai_dich_vu
 join hopdong on hopdong.id_dich_vu = dichvu.id_dich_vu
 where year(hopdong.ngay_lam_hop_dong) = 2018 and dichvu.id_dich_vu 
 not in (select dichvu.id_dich_vu from dichvu
 where year(hopdong.ngay_lam_hop_dong) = 2019 );
 
-- task 8
-- cach 1.
select distinct khachhang.ho_ten_khach_hang from khachhang;
-- cach 2.
select khachhang.ho_ten_khach_hang 
from khachhang group by ho_ten_khach_hang;
-- cach 3.
SELECT khachhang.ho_ten_khach_hang 
from khachhang UNION
SELECT khachhang.ho_ten_khach_hang 
from khachhang;

-- Task 9
select month(ngay_lam_hop_dong) as 'thang' ,
count(month(ngay_lam_hop_dong)) as 'so_hop_dong' 
FROM hopdong
WHERE year(hopdong.ngay_lam_hop_dong) = 2019
GROUP BY ngay_lam_hop_dong
ORDER BY hopdong.ngay_lam_hop_dong;

-- Task 10
select hopdong.id_hop_dong, hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc,
hopdong.tien_dat_coc, 
count(hopdongchitiet.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem
from hopdong
join hopdongchitiet on hopdongchitiet.id_hop_dong = hopdong.id_hop_dong
group by hopdong.id_hop_dong;

-- Task 11
select hopdongchitiet.id_dich_vu_di_kem, khachhang.ho_ten_khach_hang,
loaikhach.ten_loai_khach,khachhang.dia_chi
from hopdongchitiet
join hopdong on hopdongchitiet.id_hop_dong = hopdong.id_hop_dong
join khachhang on hopdong.id_khach_hang = khachhang.id_khach_hang
join loaikhach on loaikhach.id_loai_khach = khachhang.id_loai_khach
where loaikhach.ten_loai_khach = 'Diamond' 
and (khachhang.dia_chi = 'Đà Nẵng' or khachhang.dia_chi = 'Quảng Ngãi');

-- Task 12
select hopdong.id_hop_dong, nhanvien.ho_ten_nhan_vien,
 khachhang.ho_ten_khach_hang, khachhang.SDT_kh,
dichvu.ten_dich_vu, sum(hopdongchitiet.id_hop_dong_chi_tiet) as SoLuongDichVuDikem,
hopdong.tien_dat_coc
from hopdong
join nhanvien on hopdong.id_nhan_vien = nhanvien.id_nhan_vien
join hopdongchitiet on hopdongchitiet.id_hop_dong = hopdong.id_hop_dong
join dichvu on dichvu.id_dich_vu = hopdong.id_dich_vu
join khachhang on khachhang.id_khach_hang = hopdong.id_khach_hang
WHERE (month(hopdong.ngay_lam_hop_dong) > 9 and year(hopdong.ngay_lam_hop_dong) = 2019)
and hopdong.id_hop_dong 
NOT IN (month(hopdong.ngay_lam_hop_dong) < 7 AND year(hopdong.ngay_lam_hop_dong) = 2019);

-- Task 13
select hopdongchitiet.id_dich_vu_di_kem, 
count(hopdongchitiet.id_dich_vu_di_kem) as so_lan_su_dung
from hopdongchitiet
join dichvudikem on hopdongchitiet.id_dich_vu_di_kem = dichvudikem.id_dich_vu_di_kem
group by id_dich_vu_di_kem
having so_lan_su_dung = (select count(hopdongchitiet.id_dich_vu_di_kem) as so_lan1 from hopdongchitiet
join dichvudikem on hopdongchitiet.id_dich_vu_di_kem = dichvudikem.id_dich_vu_di_kem 
order by so_lan1 asc
);

-- Task 14  
 select hopdong.id_hop_dong, loaidichvu.ten_loai_dich_vu,
 dichvudikem.ten_dich_vu_di_kem, count(hopdongchitiet.id_dich_vu_di_kem)
 as so_lan_su_dung
 from hopdongchitiet
 join dichvudikem on hopdongchitiet.id_dich_vu_di_kem = dichvudikem.id_dich_vu_di_kem 
 join hopdong on hopdongchitiet.id_hop_dong = hopdong.id_hop_dong
 join dichvu on hopdong.id_dich_vu = dichvu.id_dich_vu
 join loaidichvu on dichvu.id_loai_dich_vu = loaidichvu.id_loai_dich_vu
 group by hopdongchitiet.id_dich_vu_di_kem having so_lan_su_dung = 1;

-- Task 15
select nhanvien.id_nhan_vien, nhanvien.ho_ten_nhan_vien, hopdong.ngay_lam_hop_dong,
nhanvien.SDT_nv, nhanvien.dia_chi, count(id_hop_dong) as so_luong_hop_dong
from nhanvien
join hopdong on hopdong.id_nhan_vien = nhanvien.id_nhan_vien
group by hopdong.id_nhan_vien, year(hopdong.ngay_lam_hop_dong)
having (year(hopdong.ngay_lam_hop_dong) > 2018 and year(hopdong.ngay_lam_hop_dong) <= 2019)
and so_luong_hop_dong <= 3 ;

-- Task 16

