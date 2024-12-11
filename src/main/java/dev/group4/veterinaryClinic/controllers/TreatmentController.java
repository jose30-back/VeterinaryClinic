package dev.group4.veterinaryClinic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.group4.veterinaryClinic.Models.TreatmentModel;
import dev.group4.veterinaryClinic.Services.TreatmentService;
import dev.group4.veterinaryClinic.repository.TreatmentRepository;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping
    public List<TreatmentRepository> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentRepository> getTreatmentById(@PathVariable int id) {
        return treatmentService.getTreatmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TreatmentModel createTreatment(@RequestBody TreatmentService treatment) {
        return (TreatmentModel) treatmentService.saveTreatment((TreatmentRepository) treatment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentRepository> updateTreatment(@PathVariable int id, @RequestBody TreatmentService treatment) {
        return treatmentService.getTreatmentById(id).map(existingTreatment -> {
            existingTreatment.setTreatmentName(treatment.getTreatmentName());
            existingTreatment.setTreatmentDescription(treatment.getTreatmentDescription());
            existingTreatment.setPatientId(treatment.getPatientId());
            return ResponseEntity.ok(treatmentService.saveTreatment(existingTreatment));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable int id) {
        if (treatmentService.getTreatmentById(id).isPresent()) {
            treatmentService.deleteTreatment(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
