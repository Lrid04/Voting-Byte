package org.votingbackend.services.Session;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Session;

import java.util.Date;
import java.util.List;

public interface SessionService {
    List<Session> getAll();
    String createSession(Session session) throws ExistsException;
    List<Session> getAllByIp(String ip) throws NotFoundException;
    List<Session> getAllByExpiresAtBefore(Date expiresAt);
    boolean existsByIp(String ip);
    boolean existsByDeviceId(String deviceId);
}
