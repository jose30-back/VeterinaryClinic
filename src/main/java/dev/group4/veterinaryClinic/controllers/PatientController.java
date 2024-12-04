package dev.group4.veterinaryClinic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @GetMapping("/")
    public String index(){
        return "Hello Spring";
    }
    
}
