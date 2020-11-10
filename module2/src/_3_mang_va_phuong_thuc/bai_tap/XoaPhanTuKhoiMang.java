package _3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int size;
        int [] array;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Hãy nhập độ dài của mảng mà bạn muốn: ");
            size = scanner.nextInt();
            if(size > 20)
                System.out.println("Mảng không được lớn hơn 20");
        }while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length){
            System.out.println("Hãy nhập phần tử " + i + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Danh sách mảng bạn đã nhập là: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập phần tử muốn xóa");
        int num = scanner.nextInt();
        for ( int j = 0; j< array.length; j++){
            if ( num == array[j]){
                System.out.println("Vị trí cần xóa của phần tử " + num + " là " + j);
                for ( int k = j; k < array.length - 1; k++){
                    array[k] = array[k +1];
                    System.out.println(array[k]);
                }
                array[array.length - 1] = 0;
                j--;
            }
        }
    }
}
