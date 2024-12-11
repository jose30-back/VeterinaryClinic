package dev.group4.veterinaryClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.group4.veterinaryClinic.Models.TreatmentModel;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentRepository, Integer> {

    TreatmentModel save(TreatmentModel treatment);

    void setTreatmentName(Object treatmentName);

    void setTreatmentDescription(Object treatmentDescription);

    void setPatientId(Object patientId);
}