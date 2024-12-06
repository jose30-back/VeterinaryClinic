package dev.group4.veterinaryClinic.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.group4.veterinaryClinic.Dtos.PatientDto;
import dev.group4.veterinaryClinic.Models.PatientModel;
import dev.group4.veterinaryClinic.Services.PatientService;

@RestController
@RequestMapping(path="${api-endpoint}/patients")
public class PatientController {


    private PatientService service;

    

    public PatientController(PatientService service) {
        this.service = service;
    }



    @PostMapping("")
    public ResponseEntity<PatientModel>  addPatient(@RequestBody PatientDto entity){
        PatientModel patient =  service.save(entity);
        if (patient == null) {
            ResponseEntity.badRequest();
            
        }

        return ResponseEntity.status(201).body(patient);
    }

    @GetMapping("")
    public List<PatientModel> listPatients(){
        return service.findAll();
    }
   
}
