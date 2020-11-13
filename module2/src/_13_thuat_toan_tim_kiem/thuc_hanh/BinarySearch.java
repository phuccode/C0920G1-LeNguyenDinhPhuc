package _13_thuat_toan_tim_kiem.thuc_hanh;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low){
            int mid = (low + high) / 2;
            if(key < list[mid] ){
                high = mid - 1;
            }
            else if(key == list[mid]){
                return mid;
            }
            else if(key > list[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử ");
        int number = input.nextInt();
        int[] list = new int[number];
        for(int i = 0; i < list.length; i++){
            System.out.println("Phần tử thứ" + i);
            list[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(list));
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 11));
        System.out.println(binarySearch(list, 79));
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 80));
    }
}
