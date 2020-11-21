package case_study.libs;

import case_study.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerManage {
    public List<Customer> customerList = new ArrayList<>();
    String fileCustomer = "src/case_study/data/Customer.csv";
    String fileBooking = "src/case_study/data/Booking.csv";
    //Customer
    //Phương thức add customer
    public void addNewCustomer(){
        Customer customer = new Customer(inputNameCustomer(),inputBirth(),inputGender(), inputCmnd()
                ,inputPhoneNumber(),inputEmail(),inputAddress());
        customerList.add(customer);
        try {
            BufferedWriter writerCustomer = new BufferedWriter(new FileWriter(fileCustomer));
            for(Customer customer1 : customerList){
                writerCustomer.write(customer1.getCustomerName() + "," + customer1.getBirthday()
                        + "," + customer1.getGender() + "," + customer1.getNumID() + "," + customer1.getNumPhone()
                        + "," + customer1.getEmail() + "," + customer1.getAddress() + "," + customer1.getUseService());
                writerCustomer.newLine();
            }
            writerCustomer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Phương thức hiện danh sách customer đã lưu
    public void showInformationCustomers(){
        readDataCus();
        //Sắp xếp sản phẩm tăng dần theo tên sản phẩm
        Collections.sort(customerList);
        for( Customer customer : customerList){
            customer.showInfor();
        }
    }
    //Phương thức cho khách hàng chọn loại phòng
//    public void addNewBooking(){
//        Customer customerBooking;
//        showInformationCustomers();
//        System.out.println("Choose customer for booking");
//        int choose = getScan().nextInt();
//        for (Customer customer : customerList) {
//            if (choose == customerList.indexOf(customer) + 1) {
//                customerBooking = customer;
//            }
//        }
//        System.out.println("1. Villa");
//        System.out.println("2. House");
//        System.out.println("3. Room");
//        switch (getScan().nextLine()){
//            case "1":
////                showVilla();
////                System.out.println("Choose name villa you want: ");
////                String chooseVilla = getScan().nextLine();
////                for(Villa villa : servicesVillaList){
////                    if (chooseVilla.equals(villa.getNameService())){
////                        try {
////                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileBooking));
////                            for (Customer customer : customerList){
//////                                bufferedWriter.write();
////
////                            }
////                        } catch (IOException e) {
////                            e.printStackTrace();
////                        }
////                    }
////                }
//                break;
//            case "2":
////                ServiceManage;
//                break;
//            case "3":
////                showRoom();
//                break;
//        }
//    }


    //Đọc file csv Customer
    public void readDataCus(){
        try {
            BufferedReader bufferedReaderCus = new BufferedReader(new FileReader(fileCustomer));
            String line;
            while ((line = bufferedReaderCus.readLine()) != null){
                String[] cusSplit;
                cusSplit = line.split(",");
                Customer customer = new Customer(cusSplit[0],cusSplit[1],cusSplit[2],cusSplit[3],cusSplit[4],
                        cusSplit[5],cusSplit[6]);
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Cus
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
    //--------------------------------

    //Phương thức getScan để sử dụng Scanner cho dễ
    public static Scanner getScan(){
        Scanner input = new Scanner(System.in);
        return input;
    }
}
