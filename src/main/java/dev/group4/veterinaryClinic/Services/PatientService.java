package dev.group4.veterinaryClinic.Services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import dev.group4.veterinaryClinic.Dtos.PatientDto;
import dev.group4.veterinaryClinic.Models.PatientModel;
import dev.group4.veterinaryClinic.repository.PatientRepository;

@Service
public class PatientService {
    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public PatientModel save(PatientDto patientDto) {

        PatientModel patient = new PatientModel(patientDto.name(), patientDto.age(), patientDto.race(), patientDto.gender(), patientDto.treatment(), patientDto.chipNumber());
        
        repository.save(patient);
        return patient;
        
    }


    public List<PatientModel> findAll() {
        return repository.findAll();
        
    }

    public Optional<PatientModel> findById(Long id) {
        return repository.findById(id);
        
    }

    public PatientModel update(PatientModel patient) {
        return repository.save(patient);
    }


    public void deleteById(Long id) {
        
        repository.deleteById(id); 
            
    }
}
