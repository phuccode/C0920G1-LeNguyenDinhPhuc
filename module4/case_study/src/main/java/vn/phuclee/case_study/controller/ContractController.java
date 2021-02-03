package vn.phuclee.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.phuclee.case_study.model.Contract;
import vn.phuclee.case_study.model.Service;
import vn.phuclee.case_study.services.contract.ContractService;
import vn.phuclee.case_study.services.customer.CustomerService;
import vn.phuclee.case_study.services.employee.EmployeeService;
import vn.phuclee.case_study.services.service.ServiceService;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    ContractService contractService;

    @GetMapping(value = "")
    public String showCreateForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("successMsg", "Create new contract: "+ contract.getContractId() + " done");
        return "redirect:/contract";
    }
}
