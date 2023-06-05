package com.example.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v/customer")
public class HomeController {
    @GetMapping("home")
    public String homepage() {
        return "index";
    }
}
