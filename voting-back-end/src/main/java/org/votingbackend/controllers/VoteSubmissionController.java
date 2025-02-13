package org.votingbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;
import org.votingbackend.repositories.TeamRepository;
import org.votingbackend.repositories.VoteItemRepository;
import org.votingbackend.repositories.VoteRepository;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/votes")
public class VoteSubmissionController {

    private final VoteItemRepository voteItemRepository;
    private final VoteRepository voteRepository;
    private final TeamRepository teamRepository;

    public VoteSubmissionController(VoteItemRepository voteItemRepository, VoteRepository voteRepository, TeamRepository teamRepository) {
        this.voteItemRepository = voteItemRepository;
        this.voteRepository = voteRepository;
        this.teamRepository = teamRepository;
    }

    @PostMapping("/submitVote")
    public ResponseEntity<String> submitVote(@RequestBody VoteItems voteRequest) {
        Optional<Team> teamOptional = teamRepository.findById(voteRequest.getTeam().getTeamId());
        if (teamOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid team ID");
        }
        Team team = teamOptional.get();

        VoteItems voteItems = new VoteItems();
        voteItems.setTeam(team);
        voteItems.setAppAppeal(voteRequest.getAppAppeal());
        voteItems.setAmazement(voteRequest.getAmazement());
        voteItems.setTheme(voteRequest.getTheme());
        voteItems.setPerformance(voteRequest.getPerformance());

        VoteItems savedVoteItems = voteItemRepository.save(voteItems);

        Votes vote = new Votes();
        vote.setVoteItems(savedVoteItems);
        voteRepository.save(vote);

        return ResponseEntity.ok("Vote submitted successfully!");
    }
}
