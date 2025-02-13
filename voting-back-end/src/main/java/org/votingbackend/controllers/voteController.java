package org.votingbackend.controllers;

import org.springframework.web.bind.annotation.*;
import org.votingbackend.models.Votes;
import org.votingbackend.repositories.VoteRepository;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/votes")
public class VoteController {

    private final VoteRepository voteRepository;

    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping
    public List<Votes> getAllVotes() {
        return (List<Votes>) voteRepository.findAll();
    }
}
