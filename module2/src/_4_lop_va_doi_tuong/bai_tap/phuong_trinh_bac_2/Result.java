package _4_lop_va_doi_tuong.bai_tap.phuong_trinh_bac_2;

import java.util.Scanner;

public class Result {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chương trình giải phương trinh bậc 2");
        System.out.println("Hãy nhập số a: ");
        double a = scanner.nextDouble();
        System.out.println("Hãy nhập số b: ");
        double b = scanner.nextDouble();
        System.out.println("Hãy nhập số c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        quadraticEquation.getDiscriminant();
    }
}
