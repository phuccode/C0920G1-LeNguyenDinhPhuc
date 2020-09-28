//nhập dữ liệu và hàm tính toán eval()
function result(input) {
   if (input === '='){
        document.getElementById('inputA').innerText = document.getElementById('inputA').value;
       document.getElementById('inputA').value = eval(document.getElementById('inputA').value);
   }
   else {
       document.getElementById('inputA').value += input;
   }
}


function clearA() {
    document.getElementById('inputA').value = "";
}