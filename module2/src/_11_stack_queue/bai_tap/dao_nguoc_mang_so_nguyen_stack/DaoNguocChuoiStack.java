package _11_stack_queue.bai_tap.dao_nguoc_mang_so_nguyen_stack;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocChuoiStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập nhiều từ");
        StringBuilder mWord = new StringBuilder(input.nextLine());

        String[] words = mWord.toString().split(" ");

        Stack<String> wStack = new Stack<>();

        for (String s : words){
            wStack.push(s);
        }

        System.out.println(wStack);

        mWord.delete(0,mWord.length());

        int n = wStack.size();
        for (int i = 0 ; i < n; i++){
           mWord.append(wStack.pop()).append(" ");
        }
        System.out.println(mWord);
    }
}
