package com.LinkUp.Service;

import java.util.List;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Team;

public interface TeamService {
    Team createTeam(Team team) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException;
    Team updateTeam(Long teamId, Team team) throws ValidationException, NotFoundException, InternalServerErrorException;
    void deleteTeam(Long teamId) throws NotFoundException, InternalServerErrorException;
    Team getTeamById(Long teamId) throws NotFoundException, InternalServerErrorException;
    List<Team> getAllTeams();
}

