package org.votingbackend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Session;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
    boolean existsByIp(String ip);
    boolean existsByDeviceId(String deviceId);
    List<Session> getAllByIp(String ip);
    List<Session> getAllByDeviceId(String deviceId);
    @Query("from Session where expiresAt < ?1")
    List<Session> getAllByExpiresAtBefore(Date expiresAt);
}
