package dev.group4.veterinaryClinic.Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreatmentTest {

    private Treatment treatment;

    @BeforeEach
    void setUp() {
        treatment = new Treatment();
    }

    @Test
    void testGetAndSetTreatmentId() {
        int treatmentId = 1;
        treatment.setTreatmentId(treatmentId);
        assertEquals(treatmentId, treatment.getTreatmentId());
    }

    @Test
    void testGetAndSetTreatmentName() {
        String treatmentName = "Vaccination";
        treatment.setTreatmentName(treatmentName);
        assertEquals(treatmentName, treatment.getTreatmentName());
    }

    @Test
    void testGetAndSetTreatmentDescription() {
        String treatmentDescription = "Rabies vaccination for dogs.";
        treatment.setTreatmentDescription(treatmentDescription);
        assertEquals(treatmentDescription, treatment.getTreatmentDescription());
    }

    @Test
    void testGetAndSetPatientId() {
        String patientId = "P123";
        treatment.setPatientId(patientId);
        assertEquals(patientId, treatment.getPatientId());
    }
}
