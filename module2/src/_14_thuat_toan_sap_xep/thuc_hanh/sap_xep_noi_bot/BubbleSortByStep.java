package _14_thuat_toan_sap_xep.thuc_hanh.sap_xep_noi_bot;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Hãy nhập " + list.length + " phần tử");
        for(int i = 0; i < list.length; i++){
            list[i] = scanner.nextInt();
        }
        System.out.println("Danh sách bạn vừa nhập ");
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i] + "\t");
        }
        bubbleSortByStep(list);
    }
    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Đổi " + list[i] + " với " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
            /* Array may be sorted and next pass not needed */
            if (needNextPass == false) {
                System.out.println("Mảng đã sắp xếp sẵn nên không cần sắp xếp lại");
                break;
            }
            /* Show the list after sort */
            System.out.print("Danh sách sau khi đã  " + k + "' sắp xếp: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
