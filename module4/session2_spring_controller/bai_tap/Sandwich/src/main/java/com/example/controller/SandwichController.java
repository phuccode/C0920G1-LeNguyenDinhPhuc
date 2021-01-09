package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class SandwichController {
    @RequestMapping("save")
    public String save(@RequestParam("condiment") String[] condiment) {
        if(condiment == null){
            return "false";
        }else {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, condiment);

            return "condiment";
        }
    }
}
