package org.votingbackend.services.VoteItem;

import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;

import java.util.List;

public interface VoteItemService {
    List<VoteItems> getAllVoteItems();
    String createVoteItem(VoteItems voteItems);
    int addVoteFields(int voteItemId);
    List<VoteItems> getAllVoteItemsByTeam(Team team);
}
