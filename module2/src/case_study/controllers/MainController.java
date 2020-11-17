package case_study.controllers;

import case_study.models.Customer;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public List<Villa> servicesVillaList = new ArrayList<>();
    public List<House> servicesHouseList = new ArrayList<>();
    public List<Room> servicesRoomList = new ArrayList<>();
    public List<Customer> customerList = new ArrayList<>();
    String fileVilla = "src/case_study/data/Villa.csv";
    String fileHouse = "src/case_study/data/House.csv";
    String fileRoom = "src/case_study/data/Room.csv";

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
        Customer customer = new Customer(id,inputNameCustomer(),inputBirth(),inputGender(), inputCmnd()
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
        Villa villa = new Villa(inputID(),inputNameServices(),inputAreaServices(),inputCostServices(),
                inputQuantityIncluded(),inputRentalType(),inputStandardVilla(),inputComfortableDescriptionVilla(),
                inputFloorVilla(),inputAreaPoolVilla());
        servicesVillaList.add(villa);
        try {
            BufferedWriter writerVilla = new BufferedWriter(new FileWriter(fileVilla, true));
            for(Villa villa1 : servicesVillaList){
                writerVilla.write(villa1.getId() + "," + villa1.getNameService()
                        + "," + villa1.getAreaUsed() + "," + villa1.getRentsCost()
                        + "," + villa1.getMaxPeople() + "," + villa1.getRentType()
                        + "," + villa1.getStandardRoomVilla() + "," + villa1.getDescribeOtherVilla()
                        + "," + villa1.getAreaPool() + "," + villa1.getNumberFloorVilla());
                writerVilla.newLine();
            }
            writerVilla.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức add House
    public void addNewHouse(){
        House house = new House(inputID(),inputNameServices(),inputAreaServices(),inputCostServices(),inputQuantityIncluded(),
                inputRentalType(),inputStandardHouse(),inputComfortableDescriptionHouse(),inputFloorHouse());
        servicesHouseList.add(house);
        try {
            BufferedWriter writerHouse = new BufferedWriter(new FileWriter(fileHouse,true));
            for (House house1 : servicesHouseList){
                writerHouse.write(house1.getId() + "," + house1.getNameService()
                        + "," + house1.getAreaUsed() + "," + house1.getRentsCost()
                        + "," + house1.getMaxPeople() + "," + house1.getRentType()
                        + "," + house1.getStandardRoomHouse() + "," + house1.getDescribeOtherHouse()
                        + "," + house1.getNumberFloorHouse());
                writerHouse.newLine();
            }
            writerHouse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Phương thức add Room
    public void addNewRoom(){
        String accompaniedService = "";
        Room room = new Room(inputID(),inputNameServices(),inputAreaServices(),inputCostServices(),inputQuantityIncluded(),
                inputRentalType(),accompaniedService);
        servicesRoomList.add(room);
        try {
            BufferedWriter writerRoom = new BufferedWriter(new FileWriter(fileRoom, true));
            for (Room room1 : servicesRoomList){
                writerRoom.write(room1.getId() + "," + room1.getNameService()
                        + "," + room1.getAreaUsed() + "," + room1.getRentsCost()
                        + "," + room1.getMaxPeople() + "," + room1.getRentType()
                        + "," + room1.getFreeService());
                writerRoom.newLine();
            }
            writerRoom.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Đọc file csv khi tắt chương trình arraylist sẽ không lưu và phương thức này giúp đọc lại file csv
    public void readDataVilla(){
//        try {
//            BufferedReader readerVilla = new BufferedReader(new FileReader(fileVilla));
//            String line;
//            while ((line = readerVilla.readLine()) != null){
//                String[] countLine;
//                countLine = line.split(",");
//                Villa villa = new Villa(countLine[0],countLine[1],countLine[2],countLine[3],
//                        countLine[4],countLine[5],countLine[6],countLine[7],countLine[8],countLine[9]);
//                servicesVillaList.add(villa);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void readDataHouse(){
        try {
            BufferedReader readerHouse = new BufferedReader(new FileReader(fileHouse));
            String line;
            while ((line = readerHouse.readLine()) != null){
                String[] countLine;
                countLine = line.split(",");
                House house = new House(countLine[0],countLine[1],countLine[2],countLine[3],
                        countLine[4],countLine[5],countLine[6],countLine[7],countLine[8]);
                servicesHouseList.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readDataRoom(){
        try {
            BufferedReader readerRoom = new BufferedReader(new FileReader(fileRoom));
            String line;
            while ((line = readerRoom.readLine()) != null){
                String[] countLine;
                countLine = line.split(",");
                Room room = new Room(countLine[0],countLine[1],countLine[2],countLine[3],
                        countLine[4],countLine[5],countLine[6]);
                servicesRoomList.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Phương thức hiện ra các Services
    public void showVilla(){
        try {
            BufferedReader readerVilla = new BufferedReader(new FileReader(fileVilla));
            String line;
            while ((line = readerVilla.readLine()) != null){
                String[] countLine;
                countLine = line.split(",");
                Villa villa = new Villa(countLine[0],countLine[1],countLine[2],countLine[3],
                        countLine[4],countLine[5],countLine[6],countLine[7],countLine[8],countLine[9]);
                servicesVillaList.add(villa);
                System.out.println(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for(Villa villa : servicesVillaList){
//            System.out.println(villa.showInfor());
//        }
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
    private String inputID(){
        System.out.println("Input ID services: ");
        return getScan().nextLine();
    }
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
    private String inputCmnd() {
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
