package org.votingbackend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.votingbackend.models.Team;
import org.votingbackend.repositories.TeamRepository;
import org.votingbackend.repositories.VoteItemRepository;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class teamController {
    private TeamRepository teamRepository;
    private VoteItemRepository voteItemRepository;

    @Autowired
    public teamController(TeamRepository teamRepository, VoteItemRepository voteItemRepository) {
        this.teamRepository = teamRepository;
        this.voteItemRepository = voteItemRepository;
    }
    @GetMapping(value = "/getTeams")
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    @GetMapping(value = "/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable Integer teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            return new ResponseEntity<>(teamOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
    }
}
