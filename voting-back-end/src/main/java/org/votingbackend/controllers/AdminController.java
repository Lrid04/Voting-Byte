package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.models.*;
import org.votingbackend.services.Pin.PinServiceImpl;
import org.votingbackend.services.Session.SessionServiceImpl;
import org.votingbackend.services.Team.TeamServiceImpl;
import org.votingbackend.services.admin.AdminServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(value="*")
public class AdminController {
    private final TeamServiceImpl teamServiceImpl;
    private final AdminServiceImpl adminServiceImpl;
    private final PinServiceImpl pinServiceImpl;
    private final SessionServiceImpl sessionServiceImpl;
    private final Environment env;


    @Autowired
    public AdminController(AdminServiceImpl adminServiceImpl, PinServiceImpl pinServiceImpl, TeamServiceImpl teamServiceImpl,
                           SessionServiceImpl sessionServiceImpl, Environment env) {
        this.env = env;
        this.adminServiceImpl = adminServiceImpl;
        this.pinServiceImpl = pinServiceImpl;
        this.teamServiceImpl = teamServiceImpl;
        this.sessionServiceImpl = sessionServiceImpl;
        createAdmin();
    }

    public void createAdmin(){
        Admin admin = new Admin();
        admin.setUsername(env.getProperty("admin_username"));
        admin.setPassword(env.getProperty("admin_password"));
        adminServiceImpl.createAdmin(admin);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping(value="/allTeams")
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/allPins")
    public ResponseEntity<List<Pin>> getPins() {
        return new ResponseEntity<>(pinServiceImpl.getAll(), HttpStatus.OK);
    }


    @PostMapping(value="/createTeam")
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        try{
            return new ResponseEntity<>(teamServiceImpl.createTeam(team), HttpStatus.CREATED);
        }catch(ExistsException e){
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
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/allSessions")
    public ResponseEntity<List<Session>> getSessions() {
       return new ResponseEntity<>(sessionServiceImpl.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/createSession")
    public ResponseEntity<String> createSession(@RequestBody Session session) {
        try{
            return new ResponseEntity<>(sessionServiceImpl.createSession(session), HttpStatus.CREATED);
        } catch (ExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
