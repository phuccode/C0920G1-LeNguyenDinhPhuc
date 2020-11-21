package case_study.controllers;

import case_study.commos.Validate;
import case_study.libs.CustomerManage;
import case_study.libs.ServiceManage;
import case_study.models.*;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class MainController{
    public List<Customer> customerList = new ArrayList<>();
    ServiceManage serviceManage = new ServiceManage();
    CustomerManage customerManage = new CustomerManage();
    //Hiện Menu chính
    public void displayMainMenu(){
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");

        switch (getScan().nextLine()){
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                customerManage.addNewCustomer();
                displayMainMenu();
                break;
            case "4":
                customerManage.showInformationCustomers();
                displayMainMenu();
                break;
            case "5":
                addNewBooking();
                displayMainMenu();
                break;
            case "6":
                //Show Information of Employee
            case "7":
                break;
        }
    }

    //Add Dịch vụ
    public void addNewServices(){
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");

        switch (getScan().nextLine()) {
            case "1": {
                serviceManage.addNewVilla();
                addNewServices();
                break;
            }
            case "2": {
                serviceManage.addNewHouse();
                addNewServices();
                break;
            }
            case "3": {
                serviceManage.addNewRoom();
                addNewServices();
                break;
            }
            case "4": {
                displayMainMenu();
                break;
            }
            case "5": {
                break;
            }
        }
    }
    //Hiện các Dịch vụ
    public void showServices(){
        serviceManage.readDataVilla();
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        switch (getScan().nextLine()){
            case "1":{
               serviceManage.showVilla();
               showServices();
               break;
            }
            case "2":{
                serviceManage.showHouse();
                showServices();
                break;
            }
            case "3":{
                serviceManage.showRoom();
                showServices();
                break;
            }
            case "4":{
                //
            }
            case "5":{
                //
            }
            case "6":{

            }
            case "7":{
                displayMainMenu();
                break;
            }
            case "8":{
                break;
            }
        }
    }



    //Phương thức cho khách hàng chọn loại phòng
    public void addNewBooking(){
        Customer customerBooking;
//        showInformationCustomers();
        System.out.println("Choose customer for booking");
        int choose = getScan().nextInt();
        for (Customer customer : customerList) {
            if (choose == customerList.indexOf(customer) + 1) {
                customerBooking = customer;
            }
        }
        System.out.println("1. Villa");
        System.out.println("2. House");
        System.out.println("3. Room");
        switch (getScan().nextLine()){
            case "1":
//                showVilla();
//                System.out.println("Choose name villa you want: ");
//                String chooseVilla = getScan().nextLine();
//                for(Villa villa : servicesVillaList){
//                    if (chooseVilla.equals(villa.getNameService())){
//                        try {
//                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileBooking));
//                            for (Customer customer : customerList){
////                                bufferedWriter.write();
//
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                break;
            case "2":
//                ServiceManage;
                break;
            case "3":
//                showRoom();
                break;
        }
    }


    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
