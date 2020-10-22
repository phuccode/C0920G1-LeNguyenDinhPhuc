package mang_va_phuong_thuc.thuc_hanh;

import java.util.Arrays;

public class GiaTriNhoNhatSuDungPhuongThuc {
    public static int minValue(int[] array){
        int minValue = array[0];
        for ( int i = 1; i<array.length; i++){
            if( array[i] < minValue){
                minValue = array[i];
            }
        }
        return minValue;
    };
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        int index = minValue(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Phần tử có giả trị nhỏ nhất của mảng là: " + index);
    }
}
