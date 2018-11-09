package com.example.demo.controller;

import com.example.demo.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
//@RequestMapping("/aplikacja")

public class HelloController {
    private RandomService randomService;

    @Autowired
    public HelloController(RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("Metoda hello się wykonała");
        return "Metoda hello się wykonała " + randomService.getBigInt();

    }

    @GetMapping("/example")
    @ResponseBody
    public String example() {
        System.out.println("Metoda Example się wykonała");
        return "Metoda example się wykonała";
    }
@GetMapping("/form")
    public String showForm() {
        return "form.html";
    }
    @GetMapping("/info")
    @ResponseBody
    public String showInfo(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name +":"+header);
        }
        String ip = request.getRemoteAddr();
        return ip;

    }

}
