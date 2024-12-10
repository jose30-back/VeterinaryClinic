package dev.group4.veterinaryClinic.repository;



import dev.group4.veterinaryClinic.Models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
}
