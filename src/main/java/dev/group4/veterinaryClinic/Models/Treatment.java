package dev.group4.veterinaryClinic.Models;
import jakarta.persistence.*;
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int treatmentId;
    private String treatmentName;
    private String treatmentDescription;
    private String patientId;
  
    public int getTreatmentId() {
        return treatmentId;
    }
    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }
    public String getTreatmentName() {
        return treatmentName;
    }
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }
    public String getTreatmentDescription() {
        return treatmentDescription;
    }
    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}