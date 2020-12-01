package on_tap_2;

import case_study.models.Customer;
import sun.tools.jar.Main;

import java.util.ArrayList;
import java.util.List;

public class ManagePhone {
    public static List<ListPhone> phoneList = new ArrayList<>();
    private static final String P = ",";
    public static String filePhone = "src/on_tap_2/contacts.csv";

    public static void addContact(){
        int id = (phoneList.size() > 0 ) ? (phoneList.size() + 1) : 1;
        System.out.println("Customer Id = " + id);
        ListPhone listPhone = new ListPhone(id,inputName(),inputPhone(),inputAdress(),inputEmail());
        phoneList.add(listPhone);
        String line = listPhone.getId() + P + listPhone.getName() + P + listPhone.getNumPhone() + P
                + listPhone.getAddress() + P + listPhone.getEmail();
        ReadAndWrite.writeFile(filePhone,line);
    }

    public static void read(){
        List<String[]> list = ReadAndWrite.readFile(filePhone);
        phoneList.clear();
        for (String[] strings : list){
            ListPhone listPhone = new ListPhone(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4]);
            phoneList.add(listPhone);
        }
    }

    public static void remove(){
        System.out.println("Nhập id muốn xóa");
        int choose = Maincontrol.getScan().nextInt();
        for (int i = 0; i < phoneList.size(); i++){
            if(choose == phoneList.get(i).getId()){
                ReadAndWrite.removeFile(filePhone);
                phoneList.remove(i);
                for (ListPhone listPhone : phoneList){
                    String line = listPhone.getId() + P + listPhone.getName() + P + listPhone.getNumPhone() + P
                            + listPhone.getAddress() + P + listPhone.getEmail();
                    ReadAndWrite.writeFile(filePhone,line);
                }
            }
            else {
                System.out.println("id không có trong danh sách");
                remove();
            }
        }
    }

    public static void edit(){
        System.out.println("Nhập id muốn sửa");
        int choose = Maincontrol.getScan().nextInt();
        for (int i = 0; i < phoneList.size(); i++){
            if(choose == phoneList.get(i).getId()){
                ReadAndWrite.removeFile(filePhone);
                System.out.println("1. Sửa tên");
                System.out.println("2. Sửa số điện thoại");

                switch (Maincontrol.getScan().nextLine()){
                    case "1":
                        System.out.println("Sửa");
                        String editName = Maincontrol.getScan().nextLine();
                        phoneList.get(i).setName(editName);
                        for (ListPhone listPhone : phoneList){
                            String line = listPhone.getId() + P + listPhone.getName() + P + listPhone.getNumPhone() + P
                                    + listPhone.getAddress() + P + listPhone.getEmail();
                            ReadAndWrite.writeFile(filePhone,line);
                        }
                        Maincontrol.menu();
                        break;
                    case "2":
                        System.out.println("Sửa");
                        String editPhone = Maincontrol.getScan().nextLine();
                        phoneList.get(i).setNumPhone(editPhone);
                        for (ListPhone listPhone : phoneList){
                            String line = listPhone.getId() + P + listPhone.getName() + P + listPhone.getNumPhone() + P
                                    + listPhone.getAddress() + P + listPhone.getEmail();
                            ReadAndWrite.writeFile(filePhone,line);
                        }
                        Maincontrol.menu();
                        break;
                }
            }
        }
    }


    public static void search(){
        System.out.println("Nhập id muốn tìm");
        int checkId = Maincontrol.getScan().nextInt();
        for (int i = 0; i < phoneList.size(); i++){
            if(checkId == phoneList.get(i).getId()){
                phoneList.get(i).showInfo();
            }
        }
    }

    public static String inputName(){
        System.out.println("Nhập tên");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputPhone(){
        System.out.println("Nhập số điện thoại");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputAdress(){
        System.out.println("Nhập địa chỉ");
        return Maincontrol.getScan().nextLine();
    }

    public static String inputEmail(){
        System.out.println("Nhập email");
        return Maincontrol.getScan().nextLine();
    }
}
