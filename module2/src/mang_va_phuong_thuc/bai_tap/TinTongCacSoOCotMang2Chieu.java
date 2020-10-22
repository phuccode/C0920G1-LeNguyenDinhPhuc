package mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TinTongCacSoOCotMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeRowOne;
        int sizeRowTwo;
        System.out.println("Nhập số lượng phần tử muốn nhập ở hàng thứ nhất: ");
        sizeRowOne = scanner.nextInt();
        System.out.println("Nhập số lượng phần tử muốn nhập ở hàng thứ hai: ");
        sizeRowTwo = scanner.nextInt();
        int[][] array = new int[sizeRowOne][sizeRowTwo];
        for ( int i = 0; i < sizeRowOne ; i++){
            System.out.println("Nhập phần tử " +i+ ":");
            array[0][i] = scanner.nextInt();
        }
        for ( int j = 0; j < sizeRowTwo ; j++){
            System.out.println("Nhập phần tử " +j+ ":");
            array[1][j] = scanner.nextInt();
        }
        int sum = 0;
        for ( int i = 0; i<array.length; i++){
            sum += array[i][1];
            System.out.println("Tổng các phần tử có trong cột thứ 2 là: " + sum);
        }
    }
}
