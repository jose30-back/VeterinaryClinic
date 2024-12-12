package dev.group4.veterinaryClinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.group4.veterinaryClinic.Models.AppointmentModel;
import dev.group4.veterinaryClinic.Services.AppointmentService;

public class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    private AppointmentModel appointment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        appointment = new AppointmentModel(1, LocalDateTime.now(), "Routine Check", "Annual vaccination", true, null);
    }

    @Test
    void testCreateAppointment() {
        when(appointmentService.createAppointment(any(AppointmentModel.class))).thenReturn(appointment);

        AppointmentModel createdAppointment = appointmentController.createAppointment(appointment);

        assertNotNull(createdAppointment);
        assertEquals(appointment, createdAppointment);
        verify(appointmentService, times(1)).createAppointment(appointment);
    }

    @Test
    void testGetAllAppointments() {
        List<AppointmentModel> appointments = Arrays.asList(appointment);
        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        List<AppointmentModel> result = appointmentController.getAllAppointments();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(appointment, result.get(0));
        verify(appointmentService, times(1)).getAllAppointments();
    }

    @Test
    void testSearchAppointmentById_Found() {
        when(appointmentService.getAppointmentById(1L)).thenReturn(Optional.of(appointment));

        ResponseEntity<AppointmentModel> response = appointmentController.searchAppointmentById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(appointment, response.getBody());
        verify(appointmentService, times(1)).getAppointmentById(1L);
    }

    @Test
    void testSearchAppointmentById_NotFound() {
        when(appointmentService.getAppointmentById(1L)).thenReturn(Optional.empty());

        ResponseEntity<AppointmentModel> response = appointmentController.searchAppointmentById(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(appointmentService, times(1)).getAppointmentById(1L);
    }

    @Test
    void testUpdateAppointment_Found() {
        AppointmentModel updatedAppointment = new AppointmentModel(1, LocalDateTime.now(), "Updated Query", "Updated Reason", false, null);
        when(appointmentService.updateAppointment(eq(1L), any(AppointmentModel.class))).thenReturn(updatedAppointment);

        ResponseEntity<AppointmentModel> response = appointmentController.updateAppointment(1L, updatedAppointment);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedAppointment, response.getBody());
        verify(appointmentService, times(1)).updateAppointment(eq(1L), eq(updatedAppointment));
    }

    @Test
    void testUpdateAppointment_NotFound() {
        when(appointmentService.updateAppointment(eq(1L), any(AppointmentModel.class))).thenReturn(null);

        ResponseEntity<AppointmentModel> response = appointmentController.updateAppointment(1L, appointment);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(appointmentService, times(1)).updateAppointment(eq(1L), eq(appointment));
    }

    @Test
    void testDeleteAppointment_Found() {
        when(appointmentService.deleteAppointment(1L)).thenReturn(true);

        ResponseEntity<Void> response = appointmentController.deleteAppointment(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(appointmentService, times(1)).deleteAppointment(1L);
    }

    @Test
    void testDeleteAppointment_NotFound() {
        when(appointmentService.deleteAppointment(1L)).thenReturn(false);

        ResponseEntity<Void> response = appointmentController.deleteAppointment(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(appointmentService, times(1)).deleteAppointment(1L);
    }
}
