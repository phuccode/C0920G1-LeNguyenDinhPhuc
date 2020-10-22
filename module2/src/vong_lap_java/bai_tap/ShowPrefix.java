package vong_lap_java.bai_tap;

import java.util.Scanner;

public class ShowPrefix {
    public static void main(String[] args) {
        int count = 0;
        int N = 2;
        for ( int j = 1 ; j < 100 ; j++ ){
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
