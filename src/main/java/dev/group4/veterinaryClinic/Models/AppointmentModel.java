package dev.group4.veterinaryClinic.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Appointments")
public class AppointmentModel {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)    
private long appointmentId;
private LocalDateTime dataTime;
private String typeOfQuery;
private String reasonForAppointment;
private boolean appointmentStatus;

public AppointmentModel() {
}


public AppointmentModel(int appointmentId, LocalDateTime dataTime, String typeOfQuery,
        String reasonForAppointment, boolean appointmentStatus) {
    this.appointmentId = appointmentId;
    this.dataTime = LocalDateTime.now();
    this.typeOfQuery = typeOfQuery;
    this.reasonForAppointment = reasonForAppointment;
    this.appointmentStatus = appointmentStatus;
}

public long getAppointmentId() {
    return appointmentId;
}

public LocalDateTime getDataTime() {
    return dataTime;
}

public String getTypeOfQuery() {
    return typeOfQuery;
}

public String getReasonForAppointment() {
    return reasonForAppointment;
}

public boolean isAppointmentStatus() {
    return appointmentStatus;
}

public void setAppointmentId(long appointmentId) {
    this.appointmentId = appointmentId;
}

public void setDataTime(LocalDateTime dataTime) {
    this.dataTime = dataTime;
}

public void setTypeOfQuery(String typeOfQuery) {
    this.typeOfQuery = typeOfQuery;
}

public void setReasonForAppointment(String reasonForAppointment) {
    this.reasonForAppointment = reasonForAppointment;
}

public void setAppointmentStatus(boolean appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
} 

}
