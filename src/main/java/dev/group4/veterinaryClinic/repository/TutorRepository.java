package dev.group4.veterinaryClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.group4.veterinaryClinic.Models.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
