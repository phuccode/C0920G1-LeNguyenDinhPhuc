package baitap.controller;

import baitap.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MailBoxController {

    @GetMapping(value = "box")
    public String showForm(Model model){
        model.addAttribute("mailbox", new MailBox());
        return "/create";
    }
}
