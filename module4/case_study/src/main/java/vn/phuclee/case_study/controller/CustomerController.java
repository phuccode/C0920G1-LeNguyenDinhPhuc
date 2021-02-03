package vn.phuclee.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.phuclee.case_study.model.Customer;
import vn.phuclee.case_study.services.customer.CustomerService;
import vn.phuclee.case_study.services.customer.CustomerTypeService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping(value = {""})
    public String customerList(@PageableDefault(size = 3) Pageable pageable,
         @RequestParam Optional<String> searchNameCustomer, Model model){
        String stringAfterCheck = "";
        if (!searchNameCustomer.isPresent()){
            model.addAttribute("customerList", customerService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameCustomer.get();
            model.addAttribute("customerList", customerService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@Valid @ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("successMsg", "Welcome customer: "+customer.getCustomerName());
        return "redirect:/customer";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.update(customer);
//        redirectAttributes.addFlashAttribute("successMsg", "Update student: "+student.getName() +" success!");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 3)Pageable pageable){
        return new ModelAndView("/customer/list", "customerList", customerService.search(inputSearch, pageable));
    }

    @GetMapping("/delete/{id}")
    public String showDeleteCustomer(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam String idDelete){
        customerService.delete(idDelete);
        return "redirect:/customer";
    }
}
