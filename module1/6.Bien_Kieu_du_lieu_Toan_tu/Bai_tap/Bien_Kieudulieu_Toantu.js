let a = prompt("Nhập điểm Vật lý");
let b = prompt("Nhập điểm Hóa học");
let c = prompt("Nhập điểm Sinh học");

let diemHoa = parseInt(b);
let diemLy = parseInt(a);
let diemSinh = parseInt(c);
let d = (diemHoa + diemLy + diemSinh) / 3;
document.write("Điểm trung bình cộng: " + d);
