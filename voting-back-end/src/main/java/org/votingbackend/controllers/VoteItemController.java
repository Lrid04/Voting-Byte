package org.votingbackend.controllers;

import org.springframework.web.bind.annotation.*;
import org.votingbackend.models.VoteItems;
import org.votingbackend.repositories.VoteItemRepository;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/voteItems")
public class VoteItemController {

    private final VoteItemRepository voteItemRepository;

    public VoteItemController(VoteItemRepository voteItemsRepository) {
        this.voteItemRepository = voteItemsRepository;
    }

    @GetMapping
    public List<VoteItems> getAllVoteItems() {
        return (List<VoteItems>) voteItemRepository.findAll();
    }
}
