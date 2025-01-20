package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.votingbackend.models.Votes;
import org.votingbackend.services.Vote.VoteServiceImpl;
import org.votingbackend.services.VoteItem.VoteItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/vote")
@CrossOrigin(value="*")
//@CrossOrigin(value="http://localhost:3000")
public class voteController {
    private final VoteServiceImpl voteServiceImpl;
    private final VoteItemServiceImpl voteItemServiceImpl;

    @Autowired
    public voteController(VoteServiceImpl voteServiceImpl, VoteItemServiceImpl voteItemServiceImpl) {
        this.voteServiceImpl = voteServiceImpl;
        this.voteItemServiceImpl = voteItemServiceImpl;
    }

    @GetMapping(value="/allVotes")
    public ResponseEntity<List<Votes>> getVotes(){
        return new ResponseEntity<>(voteServiceImpl.getAll(), HttpStatus.OK);
    }
}
