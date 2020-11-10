package _11_stack_queue.bai_tap.dao_nguoc_mang_so_nguyen_stack;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocSoNguyenStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử vào mảng");
        int n = input.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = input.nextInt();
            System.out.println(i);
        }

        System.out.println("Mảng lúc đầu: " + Arrays.toString(array));

        Stack<Integer> listStack = new Stack();
        for(int i = 0; i < array.length; i++){
            listStack.push(array[i]);
            System.out.println(listStack);
        }

//        for (int i = 0; i < array.length; i++){
//            listStack.pop();
//            System.out.println(listStack);
            for( int j = 0; j < array.length; j++){
                array[j] = listStack.pop();
                System.out.println(listStack);
            }
//        }
        System.out.println("Mảng sau khi đổi ngược: " + Arrays.toString(array));
    }
}
