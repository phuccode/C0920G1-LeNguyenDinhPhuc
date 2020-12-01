package test;

import java.util.Scanner;

public class Controller {
    public static void menuSaving(){
        System.out.println("Chương trình quản lý sổ tiết kiệm");
        System.out.println("1. Thêm mới sổ tiết kiệm");
        System.out.println("2. Xóa sổ tiết kiệm");
        System.out.println("3. Xem danh sách sổ tiết kiệm");
        System.out.println("4. Xem thông tin khách hàng");
        System.out.println("5. Tìm kiếm sổ tiết kiệm");
        System.out.println("6. Thoát");

        while (true){
            switch (getScan().nextLine()){
                case "1":
                    System.out.println("1. Bạn muốn nhập ngắn");
                    System.out.println("2. Bạn muốn nhập dài");
                    switch (getScan().nextLine()){
                        case "1":
                            Manager.addShortTerm();
                            menuSaving();
                            break;
                        case "2":
                            Manager.addLongTerm();
                            menuSaving();
                            break;
                    }
                case "2":
                    System.out.println("1. Bạn muốn xóa ngắn");
                    System.out.println("2. Bạn muốn xóa dài");
                    switch (getScan().nextLine()){
                        case "1":
                            Manager.deleteShort();
                            menuSaving();
                            break;
                        case "2":
                            Manager.deleteLong();
                            menuSaving();
                            break;
                    }
                case "3":
                    System.out.println("1. Bạn muốn xem ngắn");
                    System.out.println("2. Bạn muốn xem dài");
                    switch (getScan().nextLine()){
                        case "1":
                            Manager.showShortTerm();
                            menuSaving();
                            break;
                        case "2":
                            Manager.showLongTerm();
                            menuSaving();
                            break;
                    }
                case "4":
                case "5":
                case "6":
            }
        }
    }

    public static Scanner getScan(){
        return new Scanner(System.in);
    }
}
