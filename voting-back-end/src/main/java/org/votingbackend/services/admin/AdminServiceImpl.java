package org.votingbackend.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.InvalidException;
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
    public String createAdmin(Admin admin) throws ExistsException {
        try{
            if(!adminRepository.existsById(admin.getAdminId())) {
                adminRepository.save(admin);
                return "Admin created";
            }
            throw new ExistsException("Admin Already Exists");
        }catch(Exception e){
            return "Admin creation failed";
        }
    }
}
