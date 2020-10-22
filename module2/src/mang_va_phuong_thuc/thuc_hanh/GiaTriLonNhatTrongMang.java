package mang_va_phuong_thuc.thuc_hanh;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GiaTriLonNhatTrongMang {
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
            System.out.println("Hãy nhập phần tử" + i + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Danh sách mảng bạn đã nhập là: ");
        System.out.print(Arrays.toString(array));
        int max = array[0];
        int index = 1;
        for( int j = 0; j < array.length; j++){
            if (array[j] > max){
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("Phần tử lớn nhất của mảng là: "+ max + " tại vị trí" + index);
    }
}
