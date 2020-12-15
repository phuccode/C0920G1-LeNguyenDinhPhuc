package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Phúc","11/08/2999","Đà Nẵng","phuc_naruto.jpg"));
        customerList.add(new Customer("Anh","01/12/2999","Quảng Trị","phuc_naruto.jpg"));
        customerList.add(new Customer("Chiến","11/10/2999","Quảng Bình","phuc_naruto.jpg"));
    }

    public static List<Customer> getCustomerList(){
        return customerList;
    }
}
