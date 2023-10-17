package com.LinkUp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Team;
import com.LinkUp.Repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    @Transactional
    public Team createTeam(Team team) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException {
        validateTeam(team);

        try {
            return teamRepository.save(team);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Team creation failed due to data integrity violation.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to create team.");
        }
    }

    @Override
    @Transactional
    public Team updateTeam(Long teamId, Team updatedTeam) throws ValidationException, NotFoundException, InternalServerErrorException {
        validateTeam(updatedTeam);

        try {
            Team existingTeam = teamRepository.findById(teamId).orElseThrow(() -> new NotFoundException("Team not found."));
            // Update team properties here
            existingTeam.setTeamName(updatedTeam.getTeamName());
            // ... other properties
            return teamRepository.save(existingTeam);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Team not found.");
        } catch (ValidationException e) {
            throw new ValidationException("Validation failed while updating team.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to update team.");
        }
    }

    @Override
    @Transactional
    public void deleteTeam(Long teamId) throws NotFoundException, InternalServerErrorException {
        try {
            teamRepository.deleteById(teamId);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Team not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to delete team.");
        }
    }

    @Override
    public Team getTeamById(Long teamId) throws NotFoundException, InternalServerErrorException {
        try {
            return teamRepository.findById(teamId).orElseThrow(() -> new NotFoundException("Team not found."));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Team not found.");
        } catch (Exception e) {
            throw  new InternalServerErrorException("Failed to retrieve team.");
        }
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    private void validateTeam(Team team) throws ValidationException {
        if (team.getTeamName() == null || team.getTeamName().isEmpty()) {
            throw new ValidationException("Team name cannot be empty.");
        }
        // Add more validation rules as needed
    }
}