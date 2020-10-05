let number;
let temp =2; //biến chạy
let count =0; //đếm số nguyên tố
let check = false;
do{
    number =parseInt(prompt("nhap so luong so nguyen to can hien thi: "));
}  while (isNaN(number));
while (count <number) {
    for (let i=2; i<=Math.sqrt(temp);i++) {
        if(temp%i ===0) {
            check =true;
            break;
        }
    }
    if(!check) {
        document.write(temp+" đay là số nguyên tố <br>")
        count++;
    }
    check =false;
    temp++;
}