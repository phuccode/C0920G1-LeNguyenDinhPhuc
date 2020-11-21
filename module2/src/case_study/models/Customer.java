package case_study.models;

import _12_java_collection_framework.thuc_hanh.comparable_comparator.Student;
import case_study.models.Services;

public class Customer implements Comparable<Customer>{
    String customerName;
    String birthday;
    String gender;
    String numID;
    String numPhone;
    String email;
    String address;
    Services useService;

    public Customer( String customerName, String birthday, String gender, String numID, String numPhone, String email, String address, Services useService) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.gender = gender;
        this.numID = numID;
        this.numPhone = numPhone;
        this.email = email;
        this.address = address;
        this.useService = useService;
    }

    public Customer(String customerName, String birthday, String gender, String numID, String numPhone, String email, String address) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.gender = gender;
        this.numID = numID;
        this.numPhone = numPhone;
        this.email = email;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumID() {
        return numID;
    }

    public void setNumID(String numID) {
        this.numID = numID;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getUseService() {
        return useService;
    }

    public void setUseService(Services useService) {
        this.useService = useService;
    }

    public void showInfor() {
        System.out.println("Customer: " + "\n" +
                "Customer name: " + customerName + "\n" +
                "Birthday: " + birthday +"\n" +
                "Gender: " + gender + "\n" +
                "CMND: " + numID + "\n" +
                "Phone number: " + numPhone + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n" +
                "Use service: " + useService + "\n" +
                "-------------------------------------");
    }

    @Override
    public int compareTo(Customer o) {
        return this.getCustomerName().compareTo(o.getCustomerName());
    }
}
