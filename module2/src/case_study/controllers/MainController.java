package case_study.controllers;

import case_study.commos.ReadWriteFile;
import case_study.libs.CustomerManage;
import case_study.libs.EmployeeManage;
import case_study.libs.ServiceManage;
import case_study.models.*;

import java.util.*;

public class MainController {
    public List<Customer> customerList = new ArrayList<>();
    List<Villa> villaList = new ArrayList<>();
    List<House> houseList = new ArrayList<>();
    List<Room> roomList = new ArrayList<>();
    ServiceManage serviceManage = new ServiceManage();
    CustomerManage customerManage = new CustomerManage();
    EmployeeManage employeeManage = new EmployeeManage();
    String fileBooking = "src/case_study/data/Booking.csv";

    //Hiện Menu chính
    public void displayMainMenu() {
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Delete Customer");
        System.out.println("8. Exit");

        boolean isExit = false;
        while (true) {
            switch (getScan().nextLine()) {
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
                    employeeManage.addEmploy();
                    employeeManage.showInformationEmployee();
                    displayMainMenu();
                    break;
                case "7":
                    customerManage.deleteCustomer();
                    displayMainMenu();
                    break;
                case "8":
                    System.out.println("Bye bye :D ");
                    isExit = true;
                    break;
                default:
                    System.out.println("Please choose again");
            }
            if (isExit) {
                break;
            }
            displayMainMenu();
        }
    }

    //Add Dịch vụ
    public void addNewServices() {
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");

        boolean isExit = false;
        do {
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
                    System.out.println("Bye bye :D ");
                    isExit = true;
                    break;
                }
                default: {
                    System.out.println("Please choose again");
                }
            }
        } while (!isExit);
    }

    //Hiện các Dịch vụ
    public void showServices() {
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        boolean isExist = false;
        do {
            switch (getScan().nextLine()) {
                case "1": {
                    serviceManage.showVilla();
                    showServices();
                    break;
                }
                case "2": {
                    serviceManage.showHouse();
                    showServices();
                    break;
                }
                case "3": {
                    serviceManage.showRoom();
                    showServices();
                    break;
                }
                case "4": {
                    serviceManage.showVillaNotDuplicate();
                    showServices();
                    break;
                }
                case "5": {
                    serviceManage.showHouseNotDuplicate();
                    showServices();
                    break;
                }
                case "6": {
                    serviceManage.showRoomNotDuplicate();
                    showServices();
                    break;
                }
                case "7": {
                    displayMainMenu();
                    break;
                }
                case "8": {
                    System.out.println("existed !");
                    isExist = true;
                    break;
                }
            }
        } while (!isExist);
    }

    //Phương thức cho khách hàng chọn loại phòng
    public void addNewBooking() {
        String nameCus = null;
        customerList = customerManage.showInformationCustomers();
        boolean check = false;
        do {
            System.out.println("Input name customer for booking");
            String choose = getScan().nextLine();
            for (Customer customer : customerList) {
                if (choose.equals(customer.getCustomerName())) {
                    nameCus = customer.getCustomerName();
                    check = true;
                }
            }
        } while (!check);
        System.out.println("1. Villa");
        System.out.println("2. House");
        System.out.println("3. Room");
        System.out.println("4. Buy Ticket");
        System.out.println("5. Menu");
        switch (getScan().nextLine()) {
            case "1":
                villaList = serviceManage.showVilla();
                System.out.println("Input name villa you want: ");
                String chooseVilla = getScan().nextLine();
                for (Villa villa : villaList) {
                    if (chooseVilla.equals(villa.getNameService())) {
                        ReadWriteFile.writeFile(fileBooking, nameCus + ","
                                + villa.getNameService());
                    }
                }
                displayMainMenu();
                break;
            case "2":
                houseList = serviceManage.showHouse();
                System.out.println("Input name house you want: ");
                String chooseHouse = getScan().nextLine();
                for (House house : houseList) {
                    if (chooseHouse.equals(house.getNameService())) {
                        ReadWriteFile.writeFile(fileBooking, nameCus + ","
                                + house.getNameService());
                    }
                }
                displayMainMenu();
                break;
            case "3":
                roomList = serviceManage.showRoom();
                System.out.println("Input name room you want: ");
                String chooseRoom = getScan().nextLine();
                for (Room room : roomList) {
                    if (chooseRoom.equals(room.getNameService())) {
                        ReadWriteFile.writeFile(fileBooking, nameCus + ","
                                + room.getNameService());
                    }
                }
                displayMainMenu();
                break;
            case "4": {
                customerManage.buyTicket();
                displayMainMenu();
                break;
            }
            case "5":
                displayMainMenu();
                break;
        }
    }


    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan() {
        Scanner input = new Scanner(System.in);
        return input;
    }
}
