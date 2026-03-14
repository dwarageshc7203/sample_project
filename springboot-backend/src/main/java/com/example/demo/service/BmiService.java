package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bmi;

@Service
public class BmiService {

    public Bmi bmiresult(Bmi bmi) {

        double height = bmi.getHeight();
        double weight = bmi.getWeight();
        double bmiValue = weight / (height * height);

        bmi.setBmi(bmiValue);
        
        return bmi;
    }    
}
