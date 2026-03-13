package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Bmi;

@Service
public class BmiService {

    public Bmi bmicalc(Bmi bmi){
        double height = bmi.getHeight();
        double weight = bmi.getWeight();
        double Bmi = weight / ( height * height);
        bmi.setBmi(Bmi);
        return bmi;
    }
}