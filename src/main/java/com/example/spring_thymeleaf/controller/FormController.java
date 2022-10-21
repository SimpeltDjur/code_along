package com.example.spring_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/todoform")
    public String getTodoForm(){
        return "newtodoform";
    }
}