package dev.group4.veterinaryClinic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class PatientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private int age;
    private String race;
    private String gender;
    private String treatment;

    public PatientModel() {
        
    }
    public PatientModel(Long patientId, String name, int age, String race, String gender, String treatment) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
    }

    public PatientModel(String name, int age, String race, String gender, String treatment) {
        
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
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


}
