package dev.group4.veterinaryClinic.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.group4.veterinaryClinic.Models.Treatment;
import dev.group4.veterinaryClinic.Services.TreatmentService;
import java.util.List;
@RestController
@RequestMapping(path="${api-endpoint}/treatments")
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;
    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable int id) {
        return treatmentService.getTreatmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.saveTreatment(treatment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable int id, @RequestBody Treatment treatment) {
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