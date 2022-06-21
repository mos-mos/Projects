package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("show")
    public String show(Model model){
        System.out.println("show进入");
        model.addAttribute("msg","hello....thymeleaf");
        model.addAttribute("birth",new Date());
        return "demo";
    }

}
