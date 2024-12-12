package dev.group4.veterinaryClinic.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.group4.veterinaryClinic.Models.AppointmentModel;
import dev.group4.veterinaryClinic.repository.AppointmentRepository;

public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    private AppointmentModel appointment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Crear un objeto de cita de ejemplo
        appointment = new AppointmentModel(0, LocalDateTime.now(), "Routine Check", "Annual vaccination", true, null);
    }

    @Test
    void testCreateAppointment() {
        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        AppointmentModel createdAppointment = appointmentService.createAppointment(appointment);

        assertNotNull(createdAppointment);
        assertEquals("Routine Check", createdAppointment.getTypeOfQuery());
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void testGetAppointmentById() {
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Optional<AppointmentModel> foundAppointment = appointmentService.getAppointmentById(1L);

        assertTrue(foundAppointment.isPresent());
        assertEquals("Routine Check", foundAppointment.get().getTypeOfQuery());
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllAppointments() {
        List<AppointmentModel> appointments = Arrays.asList(appointment);
        when(appointmentRepository.findAll()).thenReturn(appointments);

        List<AppointmentModel> allAppointments = appointmentService.getAllAppointments();

        assertNotNull(allAppointments);
        assertEquals(1, allAppointments.size());
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    void testUpdateAppointment() {
        when(appointmentRepository.existsById(1L)).thenReturn(true);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        appointment.setTypeOfQuery("Follow-up");
        AppointmentModel updatedAppointment = appointmentService.updateAppointment(1L, appointment);

        assertNotNull(updatedAppointment);
        assertEquals("Follow-up", updatedAppointment.getTypeOfQuery());
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void testUpdateAppointmentNotFound() {
        when(appointmentRepository.existsById(1L)).thenReturn(false);

        AppointmentModel updatedAppointment = appointmentService.updateAppointment(1L, appointment);

        assertNull(updatedAppointment);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(0)).save(appointment);
    }

    @Test
    void testDeleteAppointment() {
        when(appointmentRepository.existsById(1L)).thenReturn(true);

        boolean result = appointmentService.deleteAppointment(1L);

        assertTrue(result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteAppointmentNotFound() {
        when(appointmentRepository.existsById(1L)).thenReturn(false);

        boolean result = appointmentService.deleteAppointment(1L);

        assertFalse(result);
        verify(appointmentRepository, times(1)).existsById(1L);
        verify(appointmentRepository, times(0)).deleteById(1L);
    }
}
