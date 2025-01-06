package org.votingbackend.services.Vote;

import org.votingbackend.models.Session;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;

import java.util.List;

public interface VoteService {
    List<Votes> getAll();
    String createVote(Votes vote);
    boolean existsBySessionAndVoteItems(Session session, VoteItems voteItem);
}
