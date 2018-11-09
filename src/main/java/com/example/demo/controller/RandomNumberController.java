package com.example.demo.controller;

import com.example.demo.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomNumberController {
    private RandomService randomService;
@Autowired
    public RandomNumberController(RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping("/small")
    @ResponseBody
    public String smallRandom() {
        int smallInt = randomService.getSmallInt();
        return "Losowa liczba: " + smallInt;
    }

    @GetMapping("/big")
    @ResponseBody
    public String bigRandom() {
        int bigInt = randomService.getBigInt();
        return "Losowa liczba: " + bigInt;
    }
}
