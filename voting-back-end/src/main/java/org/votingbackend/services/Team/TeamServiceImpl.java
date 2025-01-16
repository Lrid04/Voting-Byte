package org.votingbackend.services.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.exceptions.ExistsException;
import org.votingbackend.exceptions.NotFoundException;
import org.votingbackend.models.Team;
import org.votingbackend.repositories.TeamRepository;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public String createTeam(Team team) throws ExistsException {
        if (!teamRepository.existsByTeamName(team.getTeamName())) {
            teamRepository.save(team);
            return "Team created successfully";
        }
        throw new ExistsException("Team already exists");
    }

    @Override
    public String updateTeam(Team team) throws NotFoundException {
        if (teamRepository.existsByTeamName(team.getTeamName())) {
            Team updatedTeam = teamRepository.findByTeamName(team.getTeamName());
            updatedTeam.setTeamName(team.getTeamName());
            updatedTeam.setSchool(team.getSchool());
            updatedTeam.setCategory(team.getCategory());
            teamRepository.save(updatedTeam);
            return "Team updated successfully";
        }
        throw new NotFoundException("Team Not Found");
    }

    @Override
    public String deleteTeam(Team team) throws NotFoundException {
        if (teamRepository.existsByTeamName(team.getTeamName())) {
            Team deletedTeam = teamRepository.findByTeamName(team.getTeamName());
            teamRepository.delete(deletedTeam);
            return "Team deleted successfully";

        }
        throw new NotFoundException("Team Not Found");
    }

    @Override
    public Team findTeamByName(String name) {
        if (teamRepository.existsByTeamName(name)) {
            return teamRepository.findByTeamName(name);
        } else {
            return null;
        }
    }
}

