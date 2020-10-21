package intruction_java.bai_tap;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số: ");
        int num = scanner.nextInt();
        if (num < 10) {
            System.out.println(donVi(num));
        } else {
            int num2 = (num % 100) / 10;
            int num3 =  (num % 100) % 10;
            int num4 = num / 100;
            System.out.println(tram(num4) + chuc(num2) + donVi(num3));
        }
    }
    public static String donVi(int num) {
        String dvStr = "";
        switch (num) {
            case 1:
                dvStr = "một";
                break;
            case 2:
                dvStr = "hai";
                break;
            case 3:
                dvStr = "ba";
                break;
            case 4:
                dvStr = "bốn";
                break;
            case 5:
                dvStr = "năm";
                break;
            case 6:
                dvStr = "sáu";
                break;
            case 7:
                dvStr = "bảy";
                break;
            case 8:
                dvStr = "tám";
                break;
            case 9:
                dvStr = "chín";
                break;
            case 10:
                dvStr = "mười";
                break;
        }
        return dvStr;
    }

    public static String chuc(int num) {
        String chucSrt = "";
        switch (num) {
            case 1:
                chucSrt = "mười ";
                break;
            case 2:
                chucSrt = "hai mươi ";
                break;
            case 3:
                chucSrt = "ba mươi ";
                break;
            case 4:
                chucSrt = "bốn mươi ";
                break;
            case 5:
                chucSrt = "năm mươi ";
                break;
            case 6:
                chucSrt = "sáu mươi ";
                break;
            case 7:
                chucSrt = "bảy mươi ";
                break;
            case 8:
                chucSrt = "tám mươi ";
                break;
            case 9:
                chucSrt = "chín mươi ";
                break;
        }
        return chucSrt;
    }
        public static String tram(int num){
            String tramStr = "";
            switch (num) {
                case 1:
                    tramStr = "một trăm ";
                    break;
                case 2:
                    tramStr = "hai trăm ";
                    break;
                case 3:
                    tramStr = "ba trăm ";
                    break;
                case 4:
                    tramStr = "bốn mươi ";
                    break;
                case 5:
                    tramStr = "năm trăm ";
                    break;
                case 6:
                    tramStr = "sáu trăm ";
                    break;
                case 7:
                    tramStr = "bảy trăm ";
                    break;
                case 8:
                    tramStr = "tám trăm ";
                    break;
                case 9:
                    tramStr = "chín trăm ";
                    break;
            }
            return tramStr;
        }
    }
