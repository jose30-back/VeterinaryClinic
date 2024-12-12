package dev.group4.veterinaryClinic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group4.veterinaryClinic.Models.Tutor;
import dev.group4.veterinaryClinic.repository.TutorRepository;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> getAllTutores() {
        return tutorRepository.findAll();
    }

    public Tutor getTutorById(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));
    }

    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor updateTutor(Long id, Tutor tutor) {
        Tutor existingTutor = getTutorById(id);
        existingTutor.setFirstName(tutor.getFirstName());
        existingTutor.setLastName(tutor.getLastName());
        existingTutor.setPhone(tutor.getPhone());
        return tutorRepository.save(existingTutor);
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
