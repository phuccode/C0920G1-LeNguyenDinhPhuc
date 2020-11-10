package _1_intruction_java.thuc_hanh.thuc_hanh6;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Nhập năm: ");
        year = scanner.nextInt();
        boolean isLeapYear = false;
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4){
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100){
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400){
                    isLeapYear = true;
                }
            }else isLeapYear = true;
        }
        if(isLeapYear){
            System.out.println("Năm " + year + " là năm nhuận ");
        }else System.out.println("Năm " + year + " không phải là năm nhuận");
    }
}
