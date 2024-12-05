package dev.group4.veterinaryClinic.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tutores")

public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String FirstName;
    private String LastName;
    private String Phone;
//, List<PatientModel> pacientes
    public Tutor(Long id, String firstName, String lastName, String phone) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        //this.pacientes = pacientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    /* public List<PatientModel> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PatientModel> pacientes) {
        this.pacientes = pacientes;
    } */

    //@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    //private List<PatientModel> pacientes; // Relación con Paciente
}
