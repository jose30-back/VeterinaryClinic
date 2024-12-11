<<<<<<< HEAD
<<<<<<< HEAD
=======
=======

>>>>>>> cc916152488a720b7e803b71e8cb34e7c8c8cce4
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
<<<<<<< HEAD


    public PatientModel(Long patientId, String name, int age, String race, String gender, String treatment) {
=======
    private int chipNumber;

    public PatientModel() {
        
    }
    public PatientModel(Long patientId, String name, int age, String race, String gender, String treatment, int chipNumber) {
>>>>>>> cc916152488a720b7e803b71e8cb34e7c8c8cce4
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
<<<<<<< HEAD
    }


=======
        this.chipNumber = chipNumber;
    }

    public PatientModel(String name, int age, String race, String gender, String treatment, int chipNumber) {
        
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
        this.treatment = treatment;
        this.chipNumber = chipNumber;
    }


    
>>>>>>> cc916152488a720b7e803b71e8cb34e7c8c8cce4
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

<<<<<<< HEAD

}
>>>>>>> Create_Treatment
=======
    public int getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(int chipNumber) {
        this.chipNumber = chipNumber;
    }
}

>>>>>>> cc916152488a720b7e803b71e8cb34e7c8c8cce4
