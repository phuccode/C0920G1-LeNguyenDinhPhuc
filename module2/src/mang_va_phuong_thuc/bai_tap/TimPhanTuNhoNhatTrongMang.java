package mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;
public class TimPhanTuNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array;
        int size;
        System.out.println("Nhập số lượng phần tử muốn nhập vào mảng");
        size = input.nextInt();
        array = new int[size];
        for ( int i = 0 ; i < size; i++){
            System.out.println("Hãy nhập phần tử " + i + ":");
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        for ( int j = 0; j < array.length; j++){
            if ( array[j] < min ){
                min = array[j];
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là");
        System.out.println(min);
    }
}
