package dev.group4.veterinaryClinic.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.group4.veterinaryClinic.Models.Treatment;
import dev.group4.veterinaryClinic.repository.TreatmentRepository;
import java.util.List;
import java.util.Optional;
@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;
    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }
    public Optional<Treatment> getTreatmentById(int id) {
        return treatmentRepository.findById(id);
    }
    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }
    public void deleteTreatment(int id) {
        treatmentRepository.deleteById(id);
    }
}








