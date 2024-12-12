package dev.group4.veterinaryClinic.Models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tutores")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @JsonBackReference 
    private List<PatientModel> pacientes;


    public Tutor() {
    }

  
    public Tutor(Long id, String firstName, String lastName, String phone, List<PatientModel> pacientes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.pacientes = pacientes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<PatientModel> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PatientModel> pacientes) {
        this.pacientes = pacientes;
    }
}

    
