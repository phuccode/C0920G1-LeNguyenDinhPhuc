package _2_vong_lap_java.bai_tap;

import java.util.Scanner;

public class AlertPicture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Nhập lựa chọn của bạn: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (int j = 0; j < 3; j++) {
                    System.out.println("");
                    for (int i = 0; i < 7; i++) {
                        System.out.print("*");
                    }
                }
                break;
            case 2:
                for ( int i = 0; i < 6; i++){
                    System.out.println("");
                    for (int j = 0; j < i; j++){
                        System.out.print("*");
                    }
                }
                break;
            case 3:
                for (int i = 5; i >= 1; i--){
                    System.out.println("");
                    for (int j = 1; j <= i; j++){
                        System.out.print("*");
                    }
                }
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("No choice!");
        }
    }
}
