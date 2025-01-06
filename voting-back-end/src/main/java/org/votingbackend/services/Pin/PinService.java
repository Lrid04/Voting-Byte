package org.votingbackend.services.Pin;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Pin;

import java.util.List;

public interface PinService {
    List<Pin> getAll();
    String createPin(Pin pin) throws ExistsException;
    List<Pin> findAllByPinType(String type) throws NotFoundException;
}
