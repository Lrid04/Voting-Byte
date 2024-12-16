package org.votingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
    boolean existsByIp(String ip);
    boolean existsByDeviceId(String deviceId);
}
