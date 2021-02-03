package vn.phuclee.case_study.model;

import org.hibernate.annotations.GenericGenerator;
import vn.phuclee.case_study.annotation.Phone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_generator")
    @GenericGenerator(name = "customer_generator", strategy = "vn.phuclee.case_study.common.MyGenerator")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",nullable = false)
    private CustomerType customerTypeId;

    private String customerName;
    private String customerBirthday;
    private int customerGender;
    private String customerIdCard;

    @Size(min = 10, max = 10)
    @Phone
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
