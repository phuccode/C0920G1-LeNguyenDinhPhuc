
function doiTien() {
    let Inputa = document.getElementById("number").value;
    let b = document.getElementById("tu").value;
    let c = document.getElementById("xuat").value;
    let a = parseInt(Inputa);
    let Doitien;

    if( b == "VietNam" && c == "USD" ){
        Doitien = a / 23000;
    }
    if(  b == "USD" && c == "VietNam" ){
        Doitien = 23000 * a;
    }

    if( b == c){
        Doitien = a;
    }
    alert("So tien la: " + Doitien);

}
