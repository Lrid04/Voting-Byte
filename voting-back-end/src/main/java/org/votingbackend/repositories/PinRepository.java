package org.votingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.enums.Type;
import org.votingbackend.models.Pin;

import java.util.List;

@Repository
public interface PinRepository extends CrudRepository<Pin, Integer> {
    List<Pin> findByPinType(Type type);
    List<Pin> findByOwnerName(String ownerName);
    boolean existsByPin(String pin);
}
