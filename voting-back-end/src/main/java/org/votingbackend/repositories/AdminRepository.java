package org.votingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    boolean existsByUsername(String username);
}
