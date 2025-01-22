package org.votingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.Session;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;

@Repository
public interface VoteRepository extends CrudRepository<Votes, Integer> {
    boolean existsBySessionAndVoteItems(Session session, VoteItems voteItems);
}
