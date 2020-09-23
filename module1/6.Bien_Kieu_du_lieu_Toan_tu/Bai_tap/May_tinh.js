let inputA = document.getElementById("inputA");
let inputB = document.getElementById("inputB");
let addition;

function resultA(full){
    if( full === '+'){
        addition = parseInt(inputA.value) + parseInt(inputB.value);
            }
    else if( full === '-'){
        addition = inputA.value - inputB.value;
    }
    else if (full === 'X'){
        addition = inputA.value * inputB.value;
    }
    else if ( full === '/'){
        if( inputB.value == 0 ){
            alert("Số bị chia không thể bằng 0");
        }else {
            addition = inputA.value / inputB.value;
        }

    }

    document.getElementById("result").innerText = "Result Division: " + addition;

}








