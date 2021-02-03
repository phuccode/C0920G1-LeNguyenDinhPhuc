package vn.phuclee.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.phuclee.case_study.model.Employee;
import vn.phuclee.case_study.services.employee.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    PositionService positionService;

    @Autowired
    EducationService educationService;

    @Autowired
    UserService userService;


    @GetMapping(value = {""})
    public String employeeList(@PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> searchNameEmployee, Model model){
        String stringAfterCheck = "";
        if (!searchNameEmployee.isPresent()){
            model.addAttribute("employeeList", employeeService.findAllPage(pageable));
        } else {
            stringAfterCheck = searchNameEmployee.get();
            model.addAttribute("employeeList", employeeService.findByInputText(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/employee/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationList", educationService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "/employee/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes
            redirectAttributes, Model model) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationList", educationService.findAll());
            model.addAttribute("userList", userService.findAll());
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("successMsg", "Welcome employee: "+employee.getEmployeeName());
        return "redirect:/employee";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationList", educationService.findAll());
        model.addAttribute("userList", userService.findAll());
        return "/employee/edit";
    }

    @PostMapping(value = "/edit")
    public String editEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("successMsg", "Update student: "+student.getName() +" success!");
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 3)Pageable pageable){
        return new ModelAndView("/employee/list", "employeeList", employeeService.findByInputText(inputSearch, pageable));
    }

    @GetMapping("/delete/{id}")
    public String showDeleteEmployee(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int idDelete){
        employeeService.delete(idDelete);
        return "redirect:/employee";
    }
}
