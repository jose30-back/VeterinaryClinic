package dev.group4.veterinaryClinic.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.group4.veterinaryClinic.Dtos.PatientDto;
import dev.group4.veterinaryClinic.Services.PatientService;

@RestController
@RequestMapping(path="${api-endpoint}/patients")
public class PatientController {


    private PatientService service;

    

    public PatientController(PatientService service) {
        this.service = service;
    }



    @PostMapping("")
    public PatientDto addPatient(@RequestBody PatientDto entity){
        return entity;
    }

    
   
}
