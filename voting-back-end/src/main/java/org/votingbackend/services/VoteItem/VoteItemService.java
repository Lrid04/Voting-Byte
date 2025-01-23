package org.votingbackend.services.VoteItem;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;

import java.util.List;

public interface VoteItemService {
    List<VoteItems> getAllVoteItems();
    String createVoteItem(VoteItems voteItems) throws ExistsException;
    int addVoteFields(int voteItemId);
    List<VoteItems> getAllVoteItemsByTeam(Team team);
    void clearTable();
}
