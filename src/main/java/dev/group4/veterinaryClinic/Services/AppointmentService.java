package dev.group4.veterinaryClinic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group4.veterinaryClinic.Models.AppointmentModel;
import dev.group4.veterinaryClinic.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentModel createAppointment(AppointmentModel appointment){
        return appointmentRepository.save(appointment);
        
    }

    public Optional<AppointmentModel> getAppointmentById(long id) {
        return appointmentRepository.findById(id);
    }
    

    public List<AppointmentModel> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public AppointmentModel updateAppointment(long id, AppointmentModel appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setAppointmentId(id);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public boolean deleteAppointment(long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
