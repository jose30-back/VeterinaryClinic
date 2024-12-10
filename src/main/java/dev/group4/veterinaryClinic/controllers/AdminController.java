package dev.group4.veterinaryClinic.controllers;

import dev.group4.veterinaryClinic.Models.AdminModel;
import dev.group4.veterinaryClinic.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminModel> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminModel> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id)
                .map(admin -> ResponseEntity.ok().body(admin))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdminModel createAdmin(@RequestBody AdminModel admin) {
        return adminService.saveAdmin(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminModel> updateAdmin(@PathVariable int id, @RequestBody AdminModel adminDetails) {
        return adminService.getAdminById(id)
                .map(admin -> {
                    admin.setUsername(adminDetails.getUsername());
                    admin.setEmail(adminDetails.getEmail());
                    return ResponseEntity.ok().body(adminService.saveAdmin(admin));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        if (adminService.getAdminById(id).isPresent()) {
            adminService.deleteAdminById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
