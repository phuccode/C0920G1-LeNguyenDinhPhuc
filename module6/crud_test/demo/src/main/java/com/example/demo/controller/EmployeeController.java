package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        System.out.println(employeeService.findAll());
        return employeeService.findAll();
    }

//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId){
//        Employee employee = employeeService.findById(employeeId);
//        return ResponseEntity.ok().body(employee);
//    }

//    @PostMapping("/employees")
//    public Employee createEmployee(@RequestBody Employee employee){
//        return employeeService.save(employee);
//    }
}
