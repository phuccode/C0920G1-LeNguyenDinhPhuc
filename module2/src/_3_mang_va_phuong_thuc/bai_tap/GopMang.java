package _3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArrayOne;
        int sizeArrayTwo;
        System.out.println("Nhập số lượng phần tử bạn muốn nhập vào mảng thứ nhất: ");
        sizeArrayOne = scanner.nextInt();
        int[] arrayOne = new int[sizeArrayOne];
        for ( int i = 0; i < sizeArrayOne; i++){
            System.out.println("Nhập phần tử " +i+ ":");
            arrayOne[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arrayOne));
        System.out.println("Nhập số lượng phần tử bạn muốn nhập vào mảng thứ hai: ");
        sizeArrayTwo = scanner.nextInt();
        int[] arrayTwo = new int[sizeArrayTwo];
        for ( int i = 0; i < sizeArrayTwo; i++){
            System.out.println("Nhập phần tử " +i+ ":");
            arrayTwo[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arrayTwo));
        //Tạo 1 mảng mới có độ dài bằng 2 mảng đã cho cộng lại
        int[] arrayThree = new int[arrayOne.length+arrayTwo.length];
        //Duyệt và gán phần tử ở mảng thứ nhất vào mảng mới
        for ( int i = 0; i < arrayOne.length; i++){
            arrayThree[i] = arrayOne[i];
        }
        //Duyệt và gán phần tử ở mảng thứ hai vào mảng mới
        //Bắt đầu tại vị trí bằng độ dài của mảng thứ nhất
        for (int j = 0; j <= arrayTwo.length - 1; j++){
            arrayThree[arrayOne.length + j] = arrayTwo[j];
        }
        System.out.println(Arrays.toString(arrayThree));
    }
}
