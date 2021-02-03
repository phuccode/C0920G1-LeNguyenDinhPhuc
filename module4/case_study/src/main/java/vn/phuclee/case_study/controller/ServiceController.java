package vn.phuclee.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.phuclee.case_study.model.Customer;
import vn.phuclee.case_study.model.Service;
import vn.phuclee.case_study.services.service.RentTypeService;
import vn.phuclee.case_study.services.service.ServiceService;
import vn.phuclee.case_study.services.service.ServiceTypeService;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping(value = "")
    public String showCreateForm(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("serviceType", serviceTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/service/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("successMsg", "Create new service: "+service.getServiceId() + " done");
        return "redirect:/service";
    }
}
