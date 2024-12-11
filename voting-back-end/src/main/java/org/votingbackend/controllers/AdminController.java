package org.votingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.votingbackend.models.Team;
import org.votingbackend.services.TeamServiceImpl;

//TODO Add All Tables
//TODO Add All Repositories
//TODO Add All Services
@RestController
@RequestMapping("/auth")
public class AdminController {
    private TeamServiceImpl teamServiceImpl;

    @Autowired
    public AdminController(TeamServiceImpl teamServiceImpl) {this.teamServiceImpl = teamServiceImpl;}

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value="createTeam", method = RequestMethod.POST)
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        return new ResponseEntity<>(teamServiceImpl.createTeam(team), HttpStatus.CREATED);
    }
}
