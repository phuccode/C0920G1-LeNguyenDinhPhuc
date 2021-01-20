package manage_customer.demo.controller;

import manage_customer.demo.model.Customer;
import manage_customer.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = {"","/list"})
    public ModelAndView customerList(){
        List<Customer> customerList = customerService.findAll();
        return new ModelAndView("/list", "customerList", customerList);
    }
}
