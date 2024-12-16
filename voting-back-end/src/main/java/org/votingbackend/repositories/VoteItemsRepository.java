package org.votingbackend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.VoteItems;

@Repository
public interface VoteItemsRepository extends CrudRepository<VoteItems, Integer> {
    @Query("select (appAppeal+amazement+theme+performance) from VoteItems where voteItemId = ?1")
    int addVoteFields(Integer voteItemId);
}
