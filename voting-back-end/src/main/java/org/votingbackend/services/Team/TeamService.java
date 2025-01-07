package org.votingbackend.services.Team;

import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAll();
    String createTeam(Team team) throws ExistsException;
    String updateTeam(Team team) throws NotFoundException;
    String deleteTeam(Team team) throws NotFoundException;
    Team findTeamByName(String name);
}
