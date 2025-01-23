package org.votingbackend.services.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
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
    public String createSession(Session session) throws ExistsException {
        if (!sessionRepository.existsById(session.getSessionId())) {
            sessionRepository.save(session);
            return "Session created";
        }
        throw new ExistsException("Session already exists");
    }

    @Override
    public List<Session> getAllByIp(String ip) throws NotFoundException {
        if (sessionRepository.getAllByIp(ip).isEmpty()) {
            throw new NotFoundException(String.format("No session found for ip: %s", ip));
        }
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

    @Override
    public void clearTable(){
        sessionRepository.deleteAll();
    }
}
