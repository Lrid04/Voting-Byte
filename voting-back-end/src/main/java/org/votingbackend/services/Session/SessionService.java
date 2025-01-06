package org.votingbackend.services.Session;

import org.votingbackend.models.Session;

import java.util.Date;
import java.util.List;

public interface SessionService {
    List<Session> getAll();
    String createSession(Session session);
    List<Session> getAllByIp(String ip);
    List<Session> getAllByExpiresAtBefore(Date expiresAt);
    boolean existsByIp(String ip);
    boolean existsByDeviceId(String deviceId);
}
