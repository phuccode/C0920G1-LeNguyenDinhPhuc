package mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuLonNhatMang2Chieu {
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
        //Cho 1 biến max bằng phần tử đầu tiên của mảng 2 chiều
        int max = array[0][0];
        //Duyệt mảng 2 chiều
        //Sau khi kiểm tra hàng thứ nhất xong sẽ ra vòng này để tiếp tục kiểm tra phần tử trong hàng 2
        for (int i = 0; i < sizeRows; i++) {
            //Vào trong từ mảng con để so sánh giá trị max với từng phần tử trong hàng 1
            for (int j = 0; j < sizeColums; j++) {
                if (array[i][j] > max) {
                    max = array[i][j] ;
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng hai chiều là: " + max);
    }
}
