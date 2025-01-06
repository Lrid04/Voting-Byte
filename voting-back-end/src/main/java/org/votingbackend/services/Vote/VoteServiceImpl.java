package org.votingbackend.services.Vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public String createVote(Votes vote) {
        try{
            if(!voteRepository.existsById(vote.getVoteId())){
                voteRepository.save(vote);
                return "Vote created";
            }
            return "Vote already exists";
        }catch(Exception e){
            e.printStackTrace();
            return "Vote creation failed";
        }
    }

    @Override
    public boolean existsBySessionAndVoteItems(Session session, VoteItems voteItem) {
        return voteRepository.existsBySessionAndVoteItems(session, voteItem);
    }
}
