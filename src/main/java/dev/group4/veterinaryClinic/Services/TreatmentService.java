package dev.group4.veterinaryClinic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
//import dev.group4.veterinaryClinic.Models.TreatmentModel;
>>>>>>> e55cfdd4236d76578cbe5cfa53c6626574a0541d
import dev.group4.veterinaryClinic.repository.TreatmentRepository;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<TreatmentRepository> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Optional<TreatmentRepository> getTreatmentById(int id) {
        return treatmentRepository.findById(id);
    }

    public TreatmentRepository saveTreatment(TreatmentRepository existingTreatment) {
        return treatmentRepository.save(existingTreatment);
    }

    public void deleteTreatment(int id) {
        treatmentRepository.deleteById(id);
    }

    public Object getTreatmentName() {
           throw new UnsupportedOperationException("Unimplemented method 'getTreatmentName'");
    }

    public Object getTreatmentDescription() {
          throw new UnsupportedOperationException("Unimplemented method 'getTreatmentDescription'");
    }

	public Object getPatientId() {
			throw new UnsupportedOperationException("Unimplemented method 'getPatientId'");
	}
}