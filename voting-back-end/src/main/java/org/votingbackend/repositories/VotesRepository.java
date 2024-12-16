package org.votingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;

@Repository
public interface VotesRepository extends CrudRepository<Votes, Integer> {
    boolean existsBySessionAndVoteItems(int sessionId, int voteItemId);
}
