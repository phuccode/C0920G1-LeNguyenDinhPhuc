package intruction_java.bai_tap;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên của bạn: ");
        String name = scanner.nextLine();
        System.out.println("Hello " +name);
    }
}
