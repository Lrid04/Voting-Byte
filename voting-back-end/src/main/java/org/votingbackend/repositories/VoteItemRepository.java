package org.votingbackend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteItemRepository extends CrudRepository<VoteItems, Integer> {
    Optional<VoteItems> findByTeam(Team team);

      boolean existsByTeam(Team team);

    @Query("select (appAppeal+amazement+theme+performance) from VoteItems where voteItemId = ?1")
    int addVoteFields(int voteItemId);
    List<VoteItems> getAllVoteItemsByTeam(Team team);
}
