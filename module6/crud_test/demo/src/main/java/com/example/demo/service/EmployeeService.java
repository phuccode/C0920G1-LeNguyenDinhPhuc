package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
    Employee findById(int id);
}
