package org.votingbackend.services.admin;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.InvalidException;
import org.votingbackend.models.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    String createAdmin(Admin admin) throws ExistsException;
}
