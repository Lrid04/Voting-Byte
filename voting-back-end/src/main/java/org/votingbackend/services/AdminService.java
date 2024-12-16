package org.votingbackend.services;

import org.votingbackend.models.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    String createAdmin(Admin admin);
}
