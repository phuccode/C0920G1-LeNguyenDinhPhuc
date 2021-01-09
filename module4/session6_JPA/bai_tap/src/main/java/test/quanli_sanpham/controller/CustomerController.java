package test.quanli_sanpham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.quanli_sanpham.model.Customer;
import test.quanli_sanpham.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCreate(@ModelAttribute("model") Customer customer){
        customerRepository.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Customer " + customer.getFirstName() + " created successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(){
        List<Customer> customers = customerRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        System.out.println("a");
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer "+ customer.getFirstName() +" updated successfully");
        return modelAndView;
    }
}
