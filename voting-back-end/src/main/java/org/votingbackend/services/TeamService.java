package org.votingbackend.services;

import org.votingbackend.models.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();
    String createTeam(Team team);
    String updateTeam(Team team);
    String deleteTeam(Team team);
    Team findTeamByName(String name);
}
