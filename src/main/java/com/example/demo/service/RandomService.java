package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class RandomService {
    private Random random = new Random();

    public int getSmallInt(){
        return random.nextInt(100);
    }

    public int getBigInt(){
        return random.nextInt(100_000);
    }
}
