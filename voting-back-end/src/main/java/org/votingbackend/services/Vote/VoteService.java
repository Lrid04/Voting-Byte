package org.votingbackend.services.Vote;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.models.Session;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;

import java.util.List;

public interface VoteService {
    List<Votes> getAll();
    String createVote(Votes vote) throws ExistsException;
    boolean existsBySessionAndVoteItems(Session session, VoteItems voteItem);
}
