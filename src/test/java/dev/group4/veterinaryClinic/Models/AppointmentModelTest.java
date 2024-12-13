package dev.group4.veterinaryClinic.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentModelTest {

    private AppointmentModel appointment;
    private PatientModel patient;

    @BeforeEach
    void setUp() {
        patient = new PatientModel("Buddy", 5, "Golden Retriever", "Male", "Vaccination", 123456789L, null);
        appointment = new AppointmentModel(1, LocalDateTime.now(), "Routine Check", "Annual vaccination", true, patient);
    }

    @Test
    void testGetters() {
        assertEquals(1, appointment.getAppointmentId());
        assertNotNull(appointment.getDataTime());
        assertEquals("Routine Check", appointment.getTypeOfQuery());
        assertEquals("Annual vaccination", appointment.getReasonForAppointment());
        assertTrue(appointment.isAppointmentStatus());
        assertEquals(patient, appointment.getPatient());
    }

    @Test
    void testSetters() {
        appointment.setAppointmentId(2);
        LocalDateTime newTime = LocalDateTime.now().plusDays(1);
        appointment.setDataTime(newTime);
        appointment.setTypeOfQuery("Emergency");
        appointment.setReasonForAppointment("Injury");
        appointment.setAppointmentStatus(false);

        assertEquals(2, appointment.getAppointmentId());
        assertEquals(newTime, appointment.getDataTime());
        assertEquals("Emergency", appointment.getTypeOfQuery());
        assertEquals("Injury", appointment.getReasonForAppointment());
        assertFalse(appointment.isAppointmentStatus());
    }

    @Test
    void testPatientAssociation() {
        PatientModel newPatient = new PatientModel("Max", 3, "Labrador", "Male", "Dental check", 987654321L, null);
        appointment.setPatient(newPatient);

        assertEquals(newPatient, appointment.getPatient());
    }

    @Test
    void testConstructorDefaultValues() {
        AppointmentModel defaultAppointment = new AppointmentModel();

        assertEquals(0, defaultAppointment.getAppointmentId());
        assertNull(defaultAppointment.getDataTime());
        assertNull(defaultAppointment.getTypeOfQuery());
        assertNull(defaultAppointment.getReasonForAppointment());
        assertFalse(defaultAppointment.isAppointmentStatus());
        assertNull(defaultAppointment.getPatient());
    }
}
