package dev.group4.veterinaryClinic.Models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tutores")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;

    public Tutor() {}

    
    public Tutor(Long id, String firstName, String lastName, String phone, List<PatientModel> pacientes)  {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
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

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<PatientModel> pacientes; // Relación con Paciente
}
