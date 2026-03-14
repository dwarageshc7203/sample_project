package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bmi;
import com.example.demo.service.BmiService;

@RestController
public class BmiController {

    BmiService service;

    public BmiController(BmiService service){
        this.service = service;
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/bmi")
    public Bmi bmicalc(@RequestBody Bmi bmi) {
        return service.bmiresult(bmi);
    }
}
