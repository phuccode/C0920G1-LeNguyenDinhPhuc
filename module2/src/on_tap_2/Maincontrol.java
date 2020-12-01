package on_tap_2;

import java.util.Scanner;

public class Maincontrol {

    public static void menu(){
        System.out.println("1. Thêm mới");
        System.out.println("2. Sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Tìm");
        boolean check = false;
        while (true){
            switch (getScan().nextLine()){
                case "1":
                    ManagePhone.addContact();
                    menu();
                    break;
                case "2":
                    ManagePhone.edit();
                    menu();
                    break;
                case "3":
                    ManagePhone.remove();
                    menu();
                    break;
                case "4":
                    ManagePhone.search();
                    menu();
                    break;
                case "5":
                    System.exit(4);
                default:

            }
            if(!check){
                menu();
            }
        }
    }

    public static Scanner getScan(){
        return new Scanner(System.in);
    }
}
