package org.votingbackend.services.Pin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.enums.Type;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Pin;
import org.votingbackend.repositories.PinRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PinServiceImpl implements PinService {
    private final PinRepository pinRepository;

    @Autowired
    public PinServiceImpl(PinRepository pinRepository) {
        this.pinRepository = pinRepository;
    }

    @Override
    public List<Pin> getAll() {
        return (List<Pin>) pinRepository.findAll();
    }

    @Override
    public String createPin(Pin pin) throws ExistsException {
        if (!pinRepository.existsByPin(pin.getPin())) {
            pinRepository.save(pin);
            return "PIN CREATED";
        }
        throw new ExistsException("Pin Already Exists");
    }

    @Override
    public List<Pin> findAllByPinType(String type) throws NotFoundException {
        if (!pinRepository.findByPinType(Type.valueOf(type)).isEmpty()) {
            return (List<Pin>) pinRepository.findByPinType(Type.valueOf(type));
        }
            throw new NotFoundException("Pin Type Not Found");
    }
}
