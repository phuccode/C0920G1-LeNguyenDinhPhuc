package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServicelmpl implements CustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1,"Phuc", "phuc@gmail","Danang"));
        customerMap.put(2, new Customer(2,"Phuc1", "phuc1@gmail","Danang"));
        customerMap.put(3, new Customer(3,"Phuc2", "phuc2@gmail","Danang"));
        customerMap.put(4, new Customer(4,"Phuc3", "phuc3@gmail","Danang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
