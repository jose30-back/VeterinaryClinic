package ModelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.group4.veterinaryClinic.Models.Treatment;


class TreatmentModelTest {

    private Treatment treatmentModel;

    @BeforeEach
    void setUp() {
        treatmentModel = new Treatment();
    }

    @Test
    void testGetAndSetTreatmentId() {
        int treatmentId = 1;
        treatmentModel.setTreatmentId(treatmentId);
        assertEquals(treatmentId, treatmentModel.getTreatmentId());
    }

    @Test
    void testGetAndSetTreatmentName() {
        String treatmentName = "Vaccination";
        treatmentModel.setTreatmentName(treatmentName);
        assertEquals(treatmentName, treatmentModel.getTreatmentName());
    }

    @Test
    void testGetAndSetTreatmentDescription() {
        String treatmentDescription = "Rabies vaccination for dogs.";
        treatmentModel.setTreatmentDescription(treatmentDescription);
        assertEquals(treatmentDescription, treatmentModel.getTreatmentDescription());
    }

    @Test
    void testGetAndSetPatientId() {
        String patientId = "P123";
        treatmentModel.setPatientId(patientId);
        assertEquals(patientId, treatmentModel.getPatientId());
    }
}

