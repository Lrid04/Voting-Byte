package org.votingbackend.services.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.models.Session;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;
import org.votingbackend.repositories.VoteRepository;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Votes> getAll() {
        return (List<Votes>) voteRepository.findAll();
    }

    @Override
    public String createVote(Votes vote) throws ExistsException {
        if (!voteRepository.existsById(vote.getVoteId())) {
            voteRepository.save(vote);
            return "Vote created";
        }
        throw new ExistsException("Vote Already Exists");
    }

    @Override
    public boolean existsBySessionAndVoteItems(Session session, VoteItems voteItem) {
        return voteRepository.existsBySessionAndVoteItems(session, voteItem);
    }
}
