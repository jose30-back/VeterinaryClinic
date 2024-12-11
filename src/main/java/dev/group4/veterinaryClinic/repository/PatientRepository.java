package dev.group4.veterinaryClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.group4.veterinaryClinic.Models.PatientModel;

public interface PatientRepository extends JpaRepository<PatientModel, Long>{

}
