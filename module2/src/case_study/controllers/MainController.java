package case_study.controllers;

import case_study.commos.Customer;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.models.House;
import case_study.models.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public List<Villa> servicesVillaList = new ArrayList<>();
    public List<House> servicesHouseList = new ArrayList<>();
    public List<Room> servicesRoomList = new ArrayList<>();
    public List<Customer> customerList = new ArrayList<>();

    public List<Villa> getServicesVillaList() {
        return servicesVillaList;
    }

    public List<House> getServicesHouseList() {
        return servicesHouseList;
    }

    public List<Room> getServicesRoomList() {
        return servicesRoomList;
    }

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
                addNewCustomer();
                displayMainMenu();
                break;
            case "4":
                showInformationCustomers();
                displayMainMenu();
                break;
            case "5":
                addNewBooking();
                displayMainMenu();
                break;
            case "6":
                //
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
                addNewVilla();
                addNewServices();
                break;
            }
            case "2": {
                addNewHouse();
                addNewServices();
                break;
            }
            case "3": {
                addNewRoom();
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
               showVilla();
               showServices();
               break;
            }
            case "2":{
                showHouse();
                showServices();
                break;
            }
            case "3":{
                showRoom();
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
    //---------------------------------
    //Customer
    //Phương thức add customer
    public void addNewCustomer(){
        int id = (customerList.size() > 0) ? (customerList.size() + 1) : 1;
        System.out.println("Customer ID: " + id);
        Customer customer = new Customer(id,inputNameCustomer(),inputBirth(),inputGender(),inputNumID()
                ,inputPhoneNumber(),inputEmail(),inputAddress(),inputUseService());
        customerList.add(customer);
    }
    //Phương thức hiện danh sách customer đã lưu
    public void showInformationCustomers(){
        for( Customer customer : customerList){
            customer.showInfor();
        }
    }
    //Phương thức cho khách hàng chọn loại phòng
    public void addNewBooking(){
        for (Customer customer : customerList){
            System.out.println(customer.getCustomerName() + " ID: " + customerList.indexOf(customer) + 1);
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
                        showVilla();
                        break;
                    case "2":
                        showHouse();
                        break;
                    case "3":
                        showRoom();
                        break;
                }
            }
        }
    }

    //Services
    //Phương thức add Villa
    public void addNewVilla(){
        int id = (servicesVillaList.size() > 0) ? (servicesVillaList.size() + 1) : 1;
        System.out.println("Villa ID: " + id);
        Villa villa = new Villa(id,inputNameServices(),inputAreaServices(),inputCostServices(),inputQuantityIncluded(),inputRentalType(),inputStandardVilla(),inputComfortableDescriptionVilla(),inputFloorVilla(),inputAreaPoolVilla());
        servicesVillaList.add(villa);
    }

    //Phương thức add House
    public void addNewHouse(){
        int id = (servicesHouseList.size() > 0) ? (servicesHouseList.size() + 1) : 1;
        System.out.println("House ID: " + id);
        House house = new House(id,inputNameServices(),inputAreaServices(),inputCostServices(),inputQuantityIncluded(),inputRentalType(),inputStandardHouse(),inputComfortableDescriptionHouse(),inputFloorHouse());
        servicesHouseList.add(house);
    }
    //Phương thức add Room
    public void addNewRoom(){
        int id = (servicesRoomList.size() > 0) ? (servicesRoomList.size() + 1) : 1;
        System.out.println("Room ID: " + id);
        String accompaniedService = "";
        Room room = new Room(id,inputNameServices(),inputAreaServices(),inputCostServices(),inputQuantityIncluded(),inputRentalType(),accompaniedService);
        servicesRoomList.add(room);
    }

    //Phương thức hiện ra các Services
    public void showVilla(){
        for(Villa villa : servicesVillaList){
            System.out.println(villa.showInfor());
        }
    }
    public void showHouse(){
        for (House house : servicesHouseList){
            System.out.println(house.showInfor());
        }
    }
    public void showRoom(){
        for (Room room : servicesRoomList){
            System.out.println(room.showInfor());
        }
    }

    //Các phương thức để nhập vào
    //Service
    private String inputNameServices() {
        System.out.println("Input name services :  ");
        return getScan().nextLine();
    }
    private String inputAreaServices() {
        System.out.println("Input area services :  ");
        return getScan().nextLine();
    }
    private String inputCostServices() {
        System.out.println("Input cost services :  ");
        return getScan().nextLine();
    }
    private String inputQuantityIncluded() {
        System.out.println("Input Quantity Included :  ");
        return getScan().nextLine();
    }
    private String inputRentalType() {
        System.out.println("Input rental type :  ");
        return getScan().nextLine();
    }
    private String inputStandardVilla() {
        System.out.println("Input Standard Villa :  ");
        return getScan().nextLine();
    }
    private String inputComfortableDescriptionVilla() {
        System.out.println("Input Comfortable Description Villa :  ");
        return getScan().nextLine();
    }
    private String inputFloorVilla() {
        System.out.println("Input Floor Villa :  ");
        return getScan().nextLine();
    }
    private String inputStandardHouse() {
        System.out.println("Input Standard House :  ");
        return getScan().nextLine();
    }
    private String inputComfortableDescriptionHouse() {
        System.out.println("Input Comfortable Description House :  ");
        return getScan().nextLine();
    }
    private String inputFloorHouse() {
        System.out.println("Input Floor House :  ");
        return getScan().nextLine();
    }
    private String inputAreaPoolVilla() {
        System.out.println("Input pool villa :  ");
        return getScan().nextLine();
    }
    //Customer
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
    //--------------------------------

    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
