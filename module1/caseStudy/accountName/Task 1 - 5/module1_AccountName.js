function importA() {
    //đưa thông tin viết từ các ô input vào bảng
     document.getElementById('name2').innerHTML =  document.getElementById('name').value;
     document.getElementById('idCode2').innerHTML =  document.getElementById('idCode').value;
     document.getElementById('birthday2').innerHTML =  document.getElementById('birthday').value;
     document.getElementById('email2').innerHTML =  document.getElementById('email').value;
     document.getElementById('address2').innerHTML = document.getElementById('address').value;
     document.getElementById('customer2').innerHTML =  document.getElementById('customer').value;
     document.getElementById('discount2').innerHTML =  document.getElementById('discount').value;
     document.getElementById('amount2').innerHTML =  document.getElementById('amount').value;
     document.getElementById('rentDays2').innerHTML =  document.getElementById('rentDays').value;
     document.getElementById('suv2').innerHTML =  document.getElementById('suv').value;
     document.getElementById('classify2').innerHTML =  document.getElementById('classify').value;
     //tính chi Phí
     let suv = document.getElementById('suv');
     let chiPhi ;
     switch (suv.value) {
         case "Villa" :
             chiPhi = document.getElementById('rentDays').value * 500 - (linkAddress() + linkCustomer() + linkRentdays());
             break;
         case "House" :
             chiPhi = document.getElementById('rentDays').value * 300 - (linkAddress() + linkCustomer() + linkRentdays());
            break;
         case "Room" :
             chiPhi = document.getElementById('rentDays').value * 100 - (linkAddress() + linkCustomer() + linkRentdays());
            break;
     }  document.getElementById('cacl').innerHTML = chiPhi;
     //kiểm tra tính hợp lệ của số cmnd:
    let checkValid = false;
    let regexCMND =/^[\d]{8,8}$/;
        let cmnd =  document.getElementById('idCode').value;
        if(regexCMND.test(cmnd)){
            checkValid = true;
            document.getElementById('idCode2').innerHTML = document.getElementById('idCode').value;
        }else {
            alert("Chứng minh nhân dân bạn nhập không hợp lệ!");
            document.getElementById('idCode2').innerHTML = "";
        }
    checkValid =false;
    // while ( document.getElementById('idCode').value > 0){
    //     document.getElementById('idCode2').innerHTML =  document.getElementById('idCode').value;
    //     break;
    // }
    // while (document.getElementById('idCode').value < 0){
    //     alert("Chứng minh nhân dân sai định dạng vui lòng nhập lại");
    //     document.getElementById('idCode2').innerHTML = "";
    //     break;
    // }
    //Kiểm tra tính hợp lệ của email
    let checkEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!checkEmail.test(document.getElementById('email').value)) {
        alert('Hay nhap dia chi email hop le.\nExample@gmail.com');
        document.getElementById('email2').innerHTML = "";
    }
    else{
        document.getElementById('email2').innerHTML =  document.getElementById('email').value;
    }
    //Kiểm tra định dạng của ngày sinh
    //Kiểm tra định dạng của số ngày thuê
    while ( document.getElementById('rentDays').value > 0){
        document.getElementById('rentDays2').innerHTML =  document.getElementById('rentDays').value;
        break;
    }
    while (document.getElementById('rentDays').value < 0){
        alert("Mục số ngày thuê sai định dạng vui lòng nhập lại");
        document.getElementById('rentDays2').innerHTML = "";
        break;
    }
    //Kiểm tra định dạng số người đi kèm
    while ( document.getElementById('amount').value > 0){
        document.getElementById('amount2').innerHTML =  document.getElementById('amount').value;
        break;
    }
    while (document.getElementById('amount').value < 0){
        alert("Mục số người đi kèm sai định dạng vui lòng nhập lại");
        document.getElementById('amount2').innerHTML = "";
        break;
    }
    //Xóa bỏ khoảng trắng không cần thiết và chuẩn hóa dữ liệu cho Name
    //Xóa bỏ khoảng trắng
    let name = document.getElementById("name").value;
    name = name.trim().toLowerCase();
    let tempName = "";
    for ( let i = 0 ; i < name.length ; i++ ){
        if (name.charAt(i) === " " && name.charAt(i + 1) === " "){
            continue;
        }
        if ( i === 0 || name.charAt(i - 1) ===" "){
            tempName += name.charAt(i).toUpperCase();
            console.log(tempName);
            continue;
        }
        tempName += name.charAt(i);
    }
    document.getElementById("name2").innerHTML = tempName;
    //Xóa dữ liệu khi nhập đúng ở các ô input
    document.getElementById("name").value = "";
    document.getElementById('idCode').value = "";
    document.getElementById('birthday').value = "";
    document.getElementById('email').value = "";
    document.getElementById('discount').value = "";
    document.getElementById('amount').value = "";
    document.getElementById('rentDays').value = "";
}
//Đưa thông tin từ bảng lên các ô input
function edit() {
    let name2 = document.getElementById('name2').textContent;
    document.getElementById('name').value =  name2;
    let idCode2 = document.getElementById('idCode2').textContent;
    document.getElementById('idCode').value =  idCode2;
    let birthday2 = document.getElementById('birthday2').textContent;
    document.getElementById('birthday').value =  birthday2;
    let email2 = document.getElementById('email2').textContent;
    document.getElementById('email').value =  email2;
    let address2 = document.getElementById('address2').textContent;
    document.getElementById('address').value = address2;
    let customer2 =  document.getElementById('customer2').textContent;
    document.getElementById('customer').value =  customer2;
    let discount2 =  document.getElementById('discount2').textContent;
    document.getElementById('discount').value =   discount2;
    let amount2 = document.getElementById('amount2').textContent;
    document.getElementById('amount').value =  amount2;
    let rentDays2 = document.getElementById('rentDays2').textContent;
    document.getElementById('rentDays').value =  rentDays2;
    let suv2  = document.getElementById('suv2').textContent;
    document.getElementById('suv').value =  suv2;
    let classify2 =  document.getElementById('classify2').textContent;
    document.getElementById('classify').value =  classify2;
}
//Giảm giá theo địa chỉ
function linkAddress(){
    let address = document.getElementById('address') ;
    let add;
    switch (address.value) {
        case "Đà Nẵng":
            add = 20;
            break;
        case "Huế":
            add = 10;
            break;
        case "Quảng Nam":
            add = 5;
            break;
    }
    return add;
}
//Giảm theo thời gian lưu trú
function linkRentdays() {
    let rentDays = parseInt(document.getElementById('rentDays'));
    let deal;
    if (rentDays.value > 7){
        deal = 30;
    }
    else if (rentDays.value > 5 ){
        deal = 20;
    }
    else {
        deal = 10;
    }
    return deal;
}
//Giảm giá theo loại customer
function linkCustomer(){
    let customer = document.getElementById('customer');
    let cus;
    switch (customer.value) {
        case "Diamond":
            cus = 15;
            break;
        case "Platinum":
            cus = 10;
            break;
        case "Gold":
            cus = 5;
            break;
        case "Silver":
            cus = 2;
            break;
        case "Member":
            cus = 0;
            break;
    }
    return cus;
}
//xóa các phần tử đã lưu
function deleteEdit(){
    let deleteA = confirm("Bạn có muốn xóa " + document.getElementById('name2').innerHTML + " không ? ");
    if (deleteA === true){
        document.getElementById('name2').innerHTML =  "";
        document.getElementById('idCode2').innerHTML =  "";
        document.getElementById('birthday2').innerHTML =  "";
        document.getElementById('email2').innerHTML = "";
        document.getElementById('address2').innerHTML = "";
        document.getElementById('customer2').innerHTML =  "";
        document.getElementById('discount2').innerHTML =  "";
        document.getElementById('amount2').innerHTML =  "";
        document.getElementById('rentDays2').innerHTML =  "";
        document.getElementById('suv2').innerHTML =  "";
        document.getElementById('classify2').innerHTML =  "";
        document.getElementById('cacl').innerHTML =  "";
    }
}





