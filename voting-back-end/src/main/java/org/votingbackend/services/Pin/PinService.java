package org.votingbackend.services.Pin;

import org.votingbackend.enums.Type;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Pin;

import java.util.List;

public interface PinService {
    List<Pin> getAll();
    String createPin(Type type, String company, String ownerName) throws ExistsException;
    List<Pin> findAllByPinType(String type) throws NotFoundException;
    List<Pin> findAllByOwnerName(String ownerName) throws NotFoundException;
}
