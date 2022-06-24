package com.axios.controller;

import com.axios.model.User;
import com.axios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
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

    @GetMapping("list")
    public List<User> list(){
        System.out.println("list进入");
        List<User> list = userService.list();
//        model.addAttribute("userList",list);
        list.stream().forEach(o->{
            System.out.println(o);
        });
        return list;

    }
}
