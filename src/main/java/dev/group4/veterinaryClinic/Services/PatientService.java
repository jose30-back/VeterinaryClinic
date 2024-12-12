package dev.group4.veterinaryClinic.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import dev.group4.veterinaryClinic.Dtos.PatientDto;
import dev.group4.veterinaryClinic.Models.PatientModel;
import dev.group4.veterinaryClinic.Models.Tutor;
import dev.group4.veterinaryClinic.repository.PatientRepository;
import dev.group4.veterinaryClinic.repository.TutorRepository;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    private TutorRepository tutorRepository;

    public PatientService(PatientRepository patientRepository, TutorRepository tutorRepository) {
        this.patientRepository = patientRepository;
        this.tutorRepository = tutorRepository;
    }
    public PatientModel save(PatientDto patientDto) {
        
        Optional<Tutor> optionalTutor = tutorRepository.findById(patientDto.tutorId());
        if (optionalTutor.isEmpty()) {
            throw new IllegalArgumentException("El tutor con ID " + patientDto.tutorId() + " no existe.");
        }
        Tutor tutor = optionalTutor.get();
        
        PatientModel patient = new PatientModel(
            patientDto.name(),
            patientDto.age(),
            patientDto.race(),
            patientDto.gender(),
            patientDto.treatment(),
            patientDto.chipNumber(),
            tutor
        );
        patientRepository.save(patient);
        return patient;
    }
    public List<PatientModel> findAll() {
        return patientRepository.findAll();
    }
    public Optional<PatientModel> findById(Long id) {
        return patientRepository.findById(id);
    }
    public PatientModel update(PatientModel patient) {
        
        if (patient.getTutor() != null) {
            Optional<Tutor> optionalTutor = tutorRepository.findById(patient.getTutor().getId());
            if (optionalTutor.isEmpty()) {
                throw new IllegalArgumentException("El tutor asociado no existe.");
            }
        }
        return patientRepository.save(patient);
    }
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}