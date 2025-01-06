package org.votingbackend.services.VoteItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;
import org.votingbackend.repositories.VoteItemRepository;

import java.util.List;

@Service
public class VoteItemServiceImpl implements VoteItemService {
    private final VoteItemRepository voteItemRepository;

    @Autowired
    public VoteItemServiceImpl(VoteItemRepository voteItemRepository) {
        this.voteItemRepository = voteItemRepository;
    }

    @Override
    public List<VoteItems> getAllVoteItems() {
        return (List<VoteItems>) voteItemRepository.findAll();
    }

    @Override
    public String createVoteItem(VoteItems voteItems) {
        try{
            if(!voteItemRepository.existsById(voteItems.getVoteItemId())){
                voteItemRepository.save(voteItems);
                return "Vote item created";
            }
            return "Vote item already exists";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating vote item";
        }
    }

    @Override
    public int addVoteFields(int voteItemId) {
        return voteItemRepository.addVoteFields(voteItemId);
    }

    @Override
    public List<VoteItems> getAllVoteItemsByTeam(Team team) {
        return voteItemRepository.getAllVoteItemsByTeam(team);
    }
}
