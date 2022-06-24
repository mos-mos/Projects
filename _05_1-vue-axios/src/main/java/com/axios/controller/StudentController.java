package com.axios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @RequestMapping("show")
    public String show(){
        System.out.println("show...");
        return "steel";
    }

    @RequestMapping("change")
    public String change(int id){
        System.out.println(id);
        System.out.println("change...");
        return "change";
    }
}
