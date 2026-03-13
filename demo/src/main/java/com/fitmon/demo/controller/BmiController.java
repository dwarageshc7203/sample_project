package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Bmi;
import com.example.demo.service.BmiService;

@Controller
public class BmiController {

    BmiService service;

    @PostMapping("/bmi")
    public Bmi requestMethodName(Bmi bmi) {
        System.out.println(bmi);
        return service.bmicalc(bmi);
    }

}