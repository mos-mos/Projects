package com.thymeleaf.controller;

import com.thymeleaf.model.User;
import com.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public String show(Model model){
        System.out.println("show进入");
        model.addAttribute("msg","hello....thymeleaf");
        model.addAttribute("birth",new Date());
        model.addAttribute("sex","男");
        return "demo";
    }

    @RequestMapping("list")
    public String list(Model model){
        System.out.println("list进入");
        List<User> list = userService.list();
        model.addAttribute("userList",list);
        return "demo01";

    }
}
