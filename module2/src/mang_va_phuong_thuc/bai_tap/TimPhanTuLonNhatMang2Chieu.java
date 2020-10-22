package mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class TimPhanTuLonNhatMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeRowOne;
        int sizeRowTwo;
        System.out.println("Nhập số lượng phần tử muốn nhập ở hàng thứ nhất: ");
        sizeRowOne = scanner.nextInt();
        System.out.println("Nhập số lượng phần tử muốn nhập ở hàng thứ hai: ");
        sizeRowTwo = scanner.nextInt();
        //Tạo mảng 2 chiều mới có 2 hàng bằng với số lượng đã nhập ở trên
        int[][] array = new int[sizeRowOne][sizeRowTwo];
        for ( int i = 0; i < sizeRowOne ; i++){
            System.out.println("Nhập phần tử " +i+ ":");
            array[0][i] = scanner.nextInt();
        }
        for ( int j = 0; j < sizeRowTwo ; j++){
            System.out.println("Nhập phần tử " +j+ ":");
            array[1][j] = scanner.nextInt();
        }
        //Cho 1 biến max bằng phần tử đầu tiên của mảng 2 chiều
        int max = array[0][0];
        //Duyệt mảng 2 chiều
        //Sau khi kiểm tra hàng thứ nhất xong sẽ ra vòng này để tiếp tục kiểm tra phần tử trong hàng 2
        for (int i = 0; i < sizeRowOne; i++) {
            //Vào trong từ mảng con để so sánh giá trị max với từng phần tử trong hàng 1
            for (int j = 0; j < sizeRowTwo; j++) {
                if (array[i][j] > max) {
                    max = array[i][j] ;
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng hai chiều là: " + max);
    }
}
