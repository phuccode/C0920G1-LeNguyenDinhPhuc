package case_study.controllers;

import case_study.models.Room;
import case_study.models.Villa;
import case_study.models.House;
import case_study.models.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static List<Services> servicesVillaList = new ArrayList<>();
    public static List<Services> servicesHouseList = new ArrayList<>();
    public static List<Services> servicesRoomList = new ArrayList<>();
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
            case "2":
                showServices();
            case "3":
            case "4":
                //
            case "5":
                //
            case "6":
                //
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
            }
            case "2":{
                showHouse();
            }
            case "3":{
                showRoom();
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

            }
            case "8":{

            }
        }
    }
    //---------------------------------
    //Các phương thức add

    //Phương thức add Villa
    public void addNewVilla(){
        String nameServices = inputNameServices();
        String areaServices = inputAreaServices();
        String costServices = inputCostServices();
        String quantityIncluded = inputQuantityIncluded();
        String rentalType = inputRentalType();
        String standardVilla = inputStandardVilla();
        String comfortableDescriptionVilla = inputComfortableDescriptionVilla();
        String floorVilla = inputFloorVilla();
        String areaPoolVilla = inputAreaPoolVilla();
        Villa villa = new Villa(nameServices,areaServices,costServices,quantityIncluded,rentalType,standardVilla,comfortableDescriptionVilla,floorVilla,areaPoolVilla);
        servicesVillaList.add(villa);
    }

    //Phương thức add House
    public void addNewHouse(){
        String nameServices = inputNameServices();
        String areaServices = inputAreaServices();
        String costServices = inputCostServices();
        String quantityIncluded = inputQuantityIncluded();
        String rentalType = inputRentalType();
        String standardHouse = inputStandardHouse();
        String comfortableDescriptionHouse = inputComfortableDescriptionHouse();
        String floorHouse = inputFloorHouse();
        House house = new House(nameServices,areaServices,costServices,quantityIncluded,rentalType,standardHouse,comfortableDescriptionHouse,floorHouse);
        servicesHouseList.add(house);
    }
    //Phương thức add Room
    public void addNewRoom(){
        String nameServices = inputNameServices();
        String areaServices = inputAreaServices();
        String costServices = inputCostServices();
        String quantityIncluded = inputQuantityIncluded();
        String rentalType = inputRentalType();
        String accompaniedService = "";
        Room room = new Room(nameServices,areaServices,costServices,quantityIncluded,rentalType,accompaniedService);
        servicesRoomList.add(room);
    }
    //Các phương thức để nhập vào
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
    //--------------------------------

    //Phương thức hiện ra các Services
    public void showVilla(){
        for(Services villa : servicesVillaList){
            System.out.println(villa.showInfor());
        }
    }
    public void showHouse(){
        for (Services house : servicesHouseList){
            System.out.println(house.showInfor());
        }
    }
    public void showRoom(){
        for (Services room : servicesRoomList){
            System.out.println(room.showInfor());
        }
    }
    //------------------------------------


    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
