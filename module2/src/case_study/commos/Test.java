package case_study.commos;

import case_study.controllers.MainController;
import case_study.models.Services;
import case_study.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    List<Customer> customerList = new ArrayList<>();
    MainController services = new MainController();
    public void disPlayMenu(){
        System.out.println("1. Add Customer");
        System.out.println("2. Show Customer");
        System.out.println("3. Add New Book");
        System.out.println("4. Exit");
        switch (getScan().nextLine()){
            case "1":
//                addNewCustomer();
                disPlayMenu();
                break;
            case "2":
                showInformationCustomers();
                disPlayMenu();
                break;
            case "3":
                addNewBooking();
                break;
            case "4":
                break;
        }
    }

    //Phương thức hiện danh sách customer đã lưu
    public void showInformationCustomers(){
        for( Customer customer : customerList){
                customer.showInfor();
        }
    }

    //Phương thức add customer vào Arraylist
//    public void addNewCustomer(){
//        Customer customer = new Customer(inputNameCustomer(),inputBirth(),inputGender(),inputNumID()
//                ,inputPhoneNumber(),inputEmail(),inputAddress(),inputUseService());
//        customerList.add(customer);
//    }

    //Phương thức cho khách hàng chọn loại phòng
    public void addNewBooking(){
        for (Customer customer : customerList){
            System.out.println(customerList.indexOf(customer) + 1);
            customer.showInfor();
        }
        System.out.println("Choose customer for booking");
        int choose = getScan().nextInt();
        for (Customer customer : customerList) {
            if (choose == customerList.indexOf(customer) + 1) {
                System.out.println("1. Villa");
                System.out.println("2. House");
                System.out.println("3. Room");

                switch (getScan().nextLine()){
                    case "1":
                        System.out.println();
//                        services.showVilla();
                        break;
                    case "2":
                        services.showHouse();
                        break;
                    case "3":
                        services.showRoom();
                        break;
                }
            }
        }
    }

    //Các phương thức để nhập vào
    private String inputNameCustomer() {
        System.out.println("Input name :  ");
        return getScan().nextLine();
    }
    private String inputBirth() {
        System.out.println("Input birthday :  ");
        return getScan().nextLine();
    }
    private String inputGender() {
        System.out.println("Input gender :  ");
        return getScan().nextLine();
    }
    private String inputNumID() {
        System.out.println("Input CMND :  ");
        return getScan().nextLine();
    }
    private String inputPhoneNumber() {
        System.out.println("Input phone number :  ");
        return getScan().nextLine();
    }
    private String inputEmail() {
        System.out.println("Input email :  ");
        return getScan().nextLine();
    }
    private String inputAddress() {
        System.out.println("Input address :  ");
        return getScan().nextLine();
    }
    private String inputUseService() {
        System.out.println("Input use services :  ");
        return getScan().nextLine();
    }

    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }


}
