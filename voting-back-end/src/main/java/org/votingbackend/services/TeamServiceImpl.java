package org.votingbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.votingbackend.models.Team;
import org.votingbackend.repositories.TeamRepository;

import java.util.List;
//TODO add throws to be caught
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
    public String createTeam(Team team) {
        try {
            if (!teamRepository.existsByTeamName(team.getTeamName())) {
                teamRepository.save(team);
                return "Team created successfully";
            } else {
                return "Team already exists";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateTeam(Team team) {
        if (teamRepository.existsByTeamName(team.getTeamName())) {
            try {
                Team updatedTeam = teamRepository.findByTeamName(team.getTeamName());
                updatedTeam.setTeamName(team.getTeamName());
                updatedTeam.setSchool(team.getSchool());
                updatedTeam.setType(team.getType());
                teamRepository.save(updatedTeam);
                return "Team updated successfully";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Team does not exist";
        }
    }

    @Override
    public String deleteTeam(Team team) {
        if (teamRepository.existsByTeamName(team.getTeamName())) {
            try {
                Team deletedTeam = teamRepository.findByTeamName(team.getTeamName());
                teamRepository.delete(deletedTeam);
                return "Team deleted successfully";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Team does not exist";
        }
    }

    @Override
    public Team findTeamByName(String name) {
       if(teamRepository.existsByTeamName(name)) {
           return teamRepository.findByTeamName(name);
       }else {
           return null;
       }
    }
}

