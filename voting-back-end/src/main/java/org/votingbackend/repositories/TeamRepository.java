package org.votingbackend.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
    public boolean existsByTeamName(String name);
    public Team findByTeamName(String name);
}
