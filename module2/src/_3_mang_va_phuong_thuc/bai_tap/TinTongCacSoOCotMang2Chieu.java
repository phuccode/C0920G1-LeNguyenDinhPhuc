package _3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TinTongCacSoOCotMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeRows;
        int sizeColums;
        System.out.println("Nhập số hàng: ");
        sizeRows = scanner.nextInt();
        System.out.println("Nhập số cột: ");
        sizeColums = scanner.nextInt();
        //Tạo mảng 2 chiều mới với cột và hàng bằng số lượng đã nhập ở trên
        int[][] array = new int[sizeRows][sizeColums];
        //Duyệt mảng theo cột và hàng
        for ( int i = 0; i < sizeRows ; i++){
            for (int j = 0; j < sizeColums; j++){
                System.out.println("Nhập phần tử " +i+ "-" +j);
                array[i][j] = scanner.nextInt();
            }
        }
        //In mảng vừa nhập để xem
        for ( int i = 0; i < array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }
        int sum = 0;
        System.out.println("Nhập sô cột muốn cộng: ");
        int inputIndex = scanner.nextInt();
        for ( int i = 0; i<array.length; i++){
            sum += array[i][inputIndex - 1];
        }
        System.out.println("Tổng các phần tử có trong cột thứ 2 là: " + sum);
    }
}
