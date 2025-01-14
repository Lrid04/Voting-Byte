package org.votingbackend.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.models.Admin;
import org.votingbackend.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public void createAdmin(Admin admin) {
        if (!adminRepository.existsByUsername(admin.getUsername())) {
            adminRepository.save(admin);
        }
    }
}
