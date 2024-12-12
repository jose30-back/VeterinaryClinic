package dev.group4.veterinaryClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.group4.veterinaryClinic.Models.AppointmentModel;


@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

    

}
