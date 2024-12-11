package dev.group4.veterinaryClinic.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.group4.veterinaryClinic.Models.PatientModel;
import dev.group4.veterinaryClinic.Services.PatientService;

@RestController
@RequestMapping(path="${api-endpoint}/patient")
public class PatientController {


    public PatientController(PatientService service) {
    }



    @PostMapping("")
    public PatientModel addPatient(@RequestBody PatientModel Entity){
        return Entity;
    }

    
   
}
