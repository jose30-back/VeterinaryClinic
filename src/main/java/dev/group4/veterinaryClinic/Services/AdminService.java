package dev.group4.veterinaryClinic.Services;

import dev.group4.veterinaryClinic.Models.AdminModel;
import dev.group4.veterinaryClinic.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<AdminModel> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public AdminModel saveAdmin(AdminModel admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdminById(int id) {
        adminRepository.deleteById(id);
    }
}
