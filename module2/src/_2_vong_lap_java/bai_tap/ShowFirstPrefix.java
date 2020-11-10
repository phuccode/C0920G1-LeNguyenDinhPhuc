package _2_vong_lap_java.bai_tap;

import java.util.Scanner;

public class ShowFirstPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers;
        System.out.println("Nhập số lượng số nguyên tố cần in ra");
        numbers = scanner.nextInt();
        int count = 0;
        int N = 2;
        while (count < numbers){
            int dem = 0;
            for ( int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    dem++;
                }
            }
            if (dem == 2){
                System.out.println(N);
                count++;
            }
            N++;
        }
    }
}
