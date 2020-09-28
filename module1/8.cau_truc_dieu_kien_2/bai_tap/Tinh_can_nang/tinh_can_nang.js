let weight = parseInt(prompt("input your Weight"));
let height = parseInt(prompt("input your height"));
let bmi = weight.value / (height.value^2);

        if(bmi < 18.5){
            document.write("Underweight");
        }else if(bmi >= 18.5){
            document.write("Normal");
        }else if(bmi >=25 && bmi < 30){
            document.write("Overweight");
        }else {
            document.write("Obese");
        }

