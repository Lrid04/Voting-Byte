package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.InvalidException;
import org.votingbackend.models.*;
import org.votingbackend.services.Pin.PinServiceImpl;
import org.votingbackend.services.Session.SessionServiceImpl;
import org.votingbackend.services.Team.TeamServiceImpl;
import org.votingbackend.services.VoteItem.VoteItemServiceImpl;
import org.votingbackend.services.Vote.VoteServiceImpl;
import org.votingbackend.services.admin.AdminServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AdminController {
    private final TeamServiceImpl teamServiceImpl;
    private final AdminServiceImpl adminServiceImpl;
    private final PinServiceImpl pinServiceImpl;
    private final VoteItemServiceImpl voteItemServiceImpl;
    private final VoteServiceImpl voteServiceImpl;
    private final SessionServiceImpl sessionServiceImpl;

    @Autowired
    public AdminController(AdminServiceImpl adminServiceImpl, PinServiceImpl pinServiceImpl, TeamServiceImpl teamServiceImpl,
                           VoteItemServiceImpl voteItemServiceImpl, VoteServiceImpl voteServiceImpl, SessionServiceImpl sessionServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
        this.pinServiceImpl = pinServiceImpl;
        this.teamServiceImpl = teamServiceImpl;
        this.voteItemServiceImpl = voteItemServiceImpl;
        this.voteServiceImpl = voteServiceImpl;
        this.sessionServiceImpl = sessionServiceImpl;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping(value="allTeams")
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamServiceImpl.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="createTeam", method = RequestMethod.POST)
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        try{
            return new ResponseEntity<>(teamServiceImpl.createTeam(team), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="createAdmin", method = RequestMethod.POST)
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        try{
            return new ResponseEntity<>(adminServiceImpl.createAdmin(admin), HttpStatus.CREATED);
        } catch (ExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value="createPin", method = RequestMethod.POST)
    public ResponseEntity<String> createPin(@RequestBody Pin pin) {
        try{
            return new ResponseEntity<>(pinServiceImpl.createPin(pin), HttpStatus.CREATED);
        }catch (ExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value="createSession", method = RequestMethod.POST)
    public ResponseEntity<String> createSession(@RequestBody Session session) {
        return new ResponseEntity<>(sessionServiceImpl.createSession(session), HttpStatus.CREATED);
    }
}
