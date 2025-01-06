package org.votingbackend.services.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.models.Session;
import org.votingbackend.repositories.SessionRepository;

import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> getAll() {
        return (List<Session>) sessionRepository.findAll();
    }

    @Override
    public String createSession(Session session) {
        try{
            if (!sessionRepository.existsById(session.getSessionId())){
                sessionRepository.save(session);
                return "Session created";
            }
            return "Session already exists";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating session";
        }
    }

    @Override
    public List<Session> getAllByIp(String ip) {
        return sessionRepository.getAllByIp(ip);
    }

    @Override
    public List<Session> getAllByExpiresAtBefore(Date expiresAt) {
        return sessionRepository.getAllByExpiresAtBefore(expiresAt);
    }

    @Override
    public boolean existsByIp(String ip) {
        return sessionRepository.existsByIp(ip);
    }

    @Override
    public boolean existsByDeviceId(String deviceId) {
        return sessionRepository.existsByDeviceId(deviceId);
    }
}
