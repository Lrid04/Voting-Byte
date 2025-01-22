package org.votingbackend.services.VoteItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.exceptions.ExistsException;
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
    public String createVoteItem(VoteItems voteItems) throws ExistsException {
        if (!voteItemRepository.existsById(voteItems.getVoteItemId())) {
            voteItemRepository.save(voteItems);
            return "Vote item created";
        }
        throw new ExistsException("Vote Item Already Exists");
    }

    @Override
    public int addVoteFields(int voteItemId) {
        return voteItemRepository.addVoteFields(voteItemId);
    }

    @Override
    public List<VoteItems> getAllVoteItemsByTeam(Team team) {
        return voteItemRepository.getAllVoteItemsByTeam(team);
    }

    @Override
    public void clearTable(){
        voteItemRepository.deleteAll();
    }
}
