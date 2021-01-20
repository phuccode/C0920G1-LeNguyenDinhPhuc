package com.example.controller;

import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @Autowired
    BlogService blogService;

    @GetMapping("/home")
    public String getHelloPage(Pageable pageable, Model model){
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "home";
    }
}
