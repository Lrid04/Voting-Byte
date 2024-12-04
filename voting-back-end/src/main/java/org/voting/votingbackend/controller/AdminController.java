package org.voting.votingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.voting.votingbackend.model.Database;

@RestController
@RequestMapping("/auth")
public class AdminController {
    private final Database database;

    @Autowired()
    public AdminController(Database db) {
        this.database = db;
        database.setUp();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
