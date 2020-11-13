package _1_intruction_java.bai_tap;

import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị Dollar: ");
        double dollars = scanner.nextDouble();
        double rate = dollars * 23000.0;
        System.out.println("Giá chuyển đổi sang VNĐ là: " + rate + " VNĐ");
    }
}
