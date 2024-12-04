package org.voting.votingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voting.votingbackend.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
