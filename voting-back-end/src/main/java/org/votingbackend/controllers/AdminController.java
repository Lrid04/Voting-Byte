package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.*;
import org.votingbackend.services.Pin.PinServiceImpl;
import org.votingbackend.services.Session.SessionServiceImpl;
import org.votingbackend.services.Team.TeamServiceImpl;
import org.votingbackend.services.Vote.VoteServiceImpl;
import org.votingbackend.services.VoteItem.VoteItemServiceImpl;
import org.votingbackend.services.admin.AdminServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(value="*")
//@CrossOrigin(value="http://localhost:3000")
public class AdminController {
    private final TeamServiceImpl teamServiceImpl;
    private final AdminServiceImpl adminServiceImpl;
    private final PinServiceImpl pinServiceImpl;
    private final SessionServiceImpl sessionServiceImpl;
    private final VoteServiceImpl voteServiceImpl;
    private final VoteItemServiceImpl voteItemServiceImpl;
    private final Environment env;


    @Autowired
    public AdminController(AdminServiceImpl adminServiceImpl, PinServiceImpl pinServiceImpl, TeamServiceImpl teamServiceImpl,
                           SessionServiceImpl sessionServiceImpl, Environment env, VoteServiceImpl voteServiceImpl, VoteItemServiceImpl voteItemServiceImpl) {
        this.env = env;
        this.adminServiceImpl = adminServiceImpl;
        this.pinServiceImpl = pinServiceImpl;
        this.teamServiceImpl = teamServiceImpl;
        this.sessionServiceImpl = sessionServiceImpl;
        this.voteServiceImpl = voteServiceImpl;
        this.voteItemServiceImpl = voteItemServiceImpl;
        createAdmin();
    }

    public void createAdmin(){
        Admin admin = new Admin();
        admin.setUsername(env.getProperty("admin_username"));
        admin.setPassword(env.getProperty("admin_password"));
        adminServiceImpl.createAdmin(admin);
    }

    @GetMapping(value="/allTeams")
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/allPins")
    public ResponseEntity<List<Pin>> getPins() {
        return new ResponseEntity<>(pinServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping("/deletePin")
    public ResponseEntity<String> deletePin(@RequestBody Pin pin) {
        try{
            return new ResponseEntity<>(pinServiceImpl.deletePin(pin),HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value="/createTeam")
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        try{
            return new ResponseEntity<>(teamServiceImpl.createTeam(team), HttpStatus.CREATED);
        }catch(ExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/updateTeam")
    public ResponseEntity<String> updateTeam(@RequestBody Team team) {
        try{
            return new ResponseEntity<>(teamServiceImpl.updateTeam(team), HttpStatus.OK);
        } catch(NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/deleteTeam")
    public ResponseEntity<String> deleteTeam(@RequestBody Team team) {
        try{
            return new ResponseEntity<>(teamServiceImpl.deleteTeam(team), HttpStatus.OK);
        } catch(NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/allAdmins")
    public ResponseEntity<List<Admin>> getAdmins() {
        return new ResponseEntity<>(adminServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/createPin")
    public ResponseEntity<String> createPin(@RequestBody Pin pin) {
        try{
            return new ResponseEntity<>(pinServiceImpl.createPin(pin.getPinCategory(), pin.getPinType(), pin.getCompany(), pin.getOwnerName()), HttpStatus.CREATED);
        }catch (ExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value="/allSessions")
    public ResponseEntity<List<Session>> getSessions() {
       return new ResponseEntity<>(sessionServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/createSession")
    public ResponseEntity<String> createSession(@RequestBody Session session) {
        try {
            return new ResponseEntity<>(sessionServiceImpl.createSession(session), HttpStatus.CREATED);
        } catch (ExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value="/clearTables")
    public ResponseEntity<String> clearTables() {
        pinServiceImpl.clearTable();
        sessionServiceImpl.clearTable();
        teamServiceImpl.clearTable();
        voteServiceImpl.clearTable();
        voteItemServiceImpl.clearTable();
        return new ResponseEntity<>("Tables Cleared",HttpStatus.OK);
    }

    @PostMapping(value="/clearPins")
    public ResponseEntity<String> clearPins() {
        pinServiceImpl.clearTable();
        return new ResponseEntity<>("Pins Cleared",HttpStatus.OK);
    }

    @PostMapping(value="/clearSessions")
    public ResponseEntity<String> clearSessions() {
        sessionServiceImpl.clearTable();
        return new ResponseEntity<>("Sessions Cleared",HttpStatus.OK);
    }

    @PostMapping(value="/clearTeams")
    public ResponseEntity<String> clearTeams() {
        teamServiceImpl.clearTable();
        return new ResponseEntity<>("Teams Cleared",HttpStatus.OK);
    }

    @PostMapping(value="/clearVotes")
    public ResponseEntity<String> clearVotes() {
        voteServiceImpl.clearTable();
        return new ResponseEntity<>("Votes Cleared",HttpStatus.OK);
    }

    @PostMapping(value="/clearVoteItems")
    public ResponseEntity<String> clearVoteItems() {
        voteItemServiceImpl.clearTable();
        return new ResponseEntity<>("VoteItems Cleared",HttpStatus.OK);
    }

}
