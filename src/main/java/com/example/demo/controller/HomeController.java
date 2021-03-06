package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
class HomeController {


    @GetMapping("/")
    public String home(Model model, HttpServletResponse response){
        Cookie cookie = new Cookie("lastVisist", LocalDateTime.now().toString());
        return "home";
    }
}
