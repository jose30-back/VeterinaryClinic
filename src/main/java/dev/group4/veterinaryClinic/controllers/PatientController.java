package dev.group4.veterinaryClinic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.group4.veterinaryClinic.Services.PatientService;

@RestController
public class PatientController {


    private PatientService service;

    

    public PatientController(PatientService service) {
        this.service = service;
    }



    @GetMapping("/")
    public String index(){
        return "Hello Spring";
    }

    
   
}
