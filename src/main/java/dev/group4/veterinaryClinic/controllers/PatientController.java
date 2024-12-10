package dev.group4.veterinaryClinic.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getPatientId(@PathVariable Long id){
        
        Optional<PatientModel> patient = service.findById(id);
        return ResponseEntity.status(201).body(patient.get());

    }


    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
    
        Optional<PatientModel> optionalPatient = service.findById(id);
    
        if (optionalPatient.isPresent()) {
            PatientModel patient = optionalPatient.get();
            patient.setName(patientDto.name());
            patient.setAge(patientDto.age());
            patient.setRace(patientDto.race());
            patient.setGender(patientDto.gender());
            patient.setTreatment(patientDto.treatment());
            
            PatientModel updatedPatient = service.update(patient);
    
            return ResponseEntity.status(200).body(updatedPatient);
        } else {
            return ResponseEntity.status(404).build(); 
        }
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<PatientModel> deletePatient(@PathVariable Long id){
        
        Optional<PatientModel> patient = service.findById(id);
        if (patient.isPresent()) {
            service.deleteById(id); 
            return ResponseEntity.ok(patient.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
    }


    

   
}
