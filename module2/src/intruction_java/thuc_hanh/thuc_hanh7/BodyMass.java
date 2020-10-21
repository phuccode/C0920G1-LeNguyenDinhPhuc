package intruction_java.thuc_hanh.thuc_hanh7;

import java.util.Scanner;

public class BodyMass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("Nhập cân nặng của bạn (in kilogram): ");
        weight = scanner.nextDouble();
        System.out.println("Nhập chiều cao của bạn (in meter): ");
        height = scanner.nextDouble();
        bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5){
            System.out.println("Chỉ số của bạn kém");
        }
        else if ( bmi < 25){
            System.out.println("Chỉ số của bạn bình thường");
        }
        else if (bmi < 30){
            System.out.println("Bạn bị thừa cân");
        }else System.out.println("Chỉ số của bạn quá cao vui lòng đi bác sĩ");
    }
}
