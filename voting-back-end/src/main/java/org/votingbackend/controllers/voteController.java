package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.models.Team;
import org.votingbackend.models.VoteItems;
import org.votingbackend.models.Votes;
import org.votingbackend.repositories.TeamRepository;
import org.votingbackend.repositories.VoteItemRepository;
import org.votingbackend.services.Vote.VoteServiceImpl;
import org.votingbackend.services.VoteItem.VoteItemServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vote")
@CrossOrigin(value="*")
//@CrossOrigin(value="http://localhost:3000")
public class voteController {
    private final VoteServiceImpl voteServiceImpl;
    private final VoteItemServiceImpl voteItemServiceImpl;
    private final TeamRepository teamRepository;
    private final VoteItemRepository voteItemRepository;

    @Autowired
    public voteController(VoteServiceImpl voteServiceImpl, VoteItemRepository voteItemRepository,VoteItemServiceImpl voteItemServiceImpl,TeamRepository teamRepository) {
        this.voteServiceImpl = voteServiceImpl;
        this.voteItemServiceImpl = voteItemServiceImpl;
        this.teamRepository = teamRepository;
        this.voteItemRepository=voteItemRepository;
    }

    @GetMapping(value="/allVotes")
    public ResponseEntity<List<Votes>> getVotes(){
        return new ResponseEntity<>(voteServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public
    ResponseEntity<?> castVote(@RequestBody VoteItems voteItems) {

        Optional<Team> teamOptional = teamRepository.findById(voteItems.getTeam().getTeamId());
        if (teamOptional.isEmpty()) {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
        Team team = teamOptional.get();
        voteItems.setTeam(team);


        if (voteItemRepository.existsByTeam(team)) {
            return new ResponseEntity<>("You have already voted for this team.", HttpStatus.BAD_REQUEST);
        }

        voteItemRepository.save(voteItems);
        return new ResponseEntity<>("Vote submitted successfully.", HttpStatus.OK);
    }

    @GetMapping("/results/{teamId}")
    public ResponseEntity<?> getVoteResults(@PathVariable Integer teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isEmpty()) {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }

        Optional<VoteItems> voteItemsOptional = voteItemRepository.findByTeam(teamOptional.get());

        if (voteItemsOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(voteItemsOptional.get(), HttpStatus.OK);

}}
