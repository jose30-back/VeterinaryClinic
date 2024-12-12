package dev.group4.veterinaryClinic.Models;

import dev.group4.veterinaryClinic.Dtos.TutorDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private int age;
    private String race;
    private String gender;
    private String treatment;
    private Long chipNumber;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    @JsonBackReference
    private Tutor tutor;

    public PatientModel() {

    }
    public PatientModel(Long patientId, String name, int age, String race, String gender, String treatment, Tutor tutor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
        this.tutor = tutor;
    }

    public PatientModel(String name, int age, String race, String gender, String treatment, Long chipNumber, Tutor tutor) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
        this.chipNumber = chipNumber;
        this.tutor = tutor;
    }

    
    public TutorDto getTutor() {
        if (this.tutor != null) {
            return new TutorDto(tutor.getId(), tutor.getFirstName(), tutor.getLastName(), tutor.getPhone());
        }
        return null;
    }

    
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Long getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(Long chipNumber) {
        this.chipNumber = chipNumber;
    }

    public Tutor getTutorEntity() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
