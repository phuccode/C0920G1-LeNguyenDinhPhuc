let eng = prompt("Nhập từ tiếng anh");
let ta = ["game" , "english"];
let tv = ["Trò chơi" , "Tiếng anh"];

for (i = 0 ; i < ta.length ; i++){
    if ( eng === ta[i] ){
        document.write("Tiếng Việt: " + tv[i]);
        break;
    }
    else {
        document.write("không tìm thấy");
    }
}