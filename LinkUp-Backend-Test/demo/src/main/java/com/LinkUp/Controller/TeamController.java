package com.LinkUp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LinkUp.Model.Team;
import com.LinkUp.Service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team createdTeam = teamService.createTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long teamId) {
        Team team = teamService.getTeamById(teamId);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamId, @RequestBody Team team) {
        Team updatedTeam = teamService.updateTeam(teamId, team);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.noContent().build();
    }
}

