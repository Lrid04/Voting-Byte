package org.votingbackend.services.Pin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.enums.Category;
import org.votingbackend.enums.PinType;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Pin;
import org.votingbackend.repositories.PinRepository;
import java.util.List;
import java.util.Random;

@Service
public class PinServiceImpl implements PinService {
    private final Random rand = new Random();
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
    public String createPin(Category category, PinType pinType, String company, String ownerName) throws ExistsException {
        if (!pinRepository.findByOwnerName(ownerName).isEmpty()){
            throw new ExistsException("Pin already exists");
        }
        Pin pin1 = new Pin();
        pin1.setPinCategory(category);
        pin1.setPinType(pinType);
        pin1.setCompany(company);
        pin1.setOwnerName(ownerName);
        Pin pin2 = new Pin();
        pin2.setPinCategory(category);
        pin2.setPinType(pinType);
        pin2.setCompany(company);
        pin2.setOwnerName(ownerName);
        while (true) {
            String pin = String.valueOf(rand.nextInt(1000,9999));
            if (!pinRepository.existsByPin(pin)) {
                pin1.setPin(pin);
                pinRepository.save(pin1);
                while (true) {
                    pin = String.valueOf(rand.nextInt(1000,9999));
                    if (!pinRepository.existsByPin(pin)) {
                        pin2.setPin(pin);
                        pinRepository.save(pin2);
                        break;
                    }
                }
                break;
            }
        }
        return "Pin Created Successfully";
    }

    @Override
    public List<Pin> findAllByPinType(String type) throws NotFoundException {
        if (!pinRepository.findByPinType(Category.valueOf(type)).isEmpty()) {
            return (List<Pin>) pinRepository.findByPinType(Category.valueOf(type));
        }
            throw new NotFoundException("Pin Type Not Found");
    }

    @Override
    public List<Pin> findAllByOwnerName(String ownerName) throws NotFoundException {
        return pinRepository.findByOwnerName(ownerName);
    }

    @Override
    public void clearTable(){
        pinRepository.deleteAll();
    }

    @Override
    public String deletePin(Pin pin) throws NotFoundException {
        if (!pinRepository.existsByPin(pin.getPin())) {
            pinRepository.delete(pin);
            return "Pin Deleted Successfully";
        }
        throw new NotFoundException("Pin Not Found");
    }
}
