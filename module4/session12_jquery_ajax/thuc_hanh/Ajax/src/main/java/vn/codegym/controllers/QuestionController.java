package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Question;
import vn.codegym.services.QuestionService;
import vn.codegym.services.QuestionTypeService;
import vn.codegym.services.UserService;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionTypeService questionTypeService;

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @GetMapping(value = {""})
    public String questionList(@PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> searchNameEmployee, Model model){
        String stringAfterCheck = "";
        if (!searchNameEmployee.isPresent()){
            model.addAttribute("questionList", questionService.findAllPage(pageable));
        } else {
            stringAfterCheck = searchNameEmployee.get();
            model.addAttribute("questionList", questionService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/question/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "/question/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@Valid @ModelAttribute Question question, BindingResult bindingResult, Model model) {
        new Question().validate(question, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userList", userService.findAll());
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            return "/question/create";
        }
        questionService.save(question);
        return "redirect:/question";
    }

    @GetMapping("/search")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 3)Pageable pageable){
        return new ModelAndView("/question/list", "questionList", questionService.search(inputSearch, pageable));
    }



    @GetMapping("/delete/{id}")
    public String showDeleteEmployee(@PathVariable int id, Model model){
        model.addAttribute("question", questionService.findById(id));
        return "/question/delete";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int idDelete){
        questionService.delete(idDelete);
        return "redirect:/question";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){
        model.addAttribute("question", questionService.findById(id));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "/question/edit";
    }

    @PostMapping(value = "/edit")
    public String editEmployee(@ModelAttribute Question question, RedirectAttributes redirectAttributes){
        questionService.save(question);
//        redirectAttributes.addFlashAttribute("successMsg", "Update student: "+student.getName() +" success!");
        return "redirect:/question";
    }
}
