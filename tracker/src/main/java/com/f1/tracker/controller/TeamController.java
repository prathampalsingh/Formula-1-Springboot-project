package com.f1.tracker.controller;

import com.f1.tracker.entity.*;
import com.f1.tracker.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamEntity> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable Long id) {
        return teamService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createTeam")
public TeamEntity createTeam(@RequestBody TeamEntity team) {
    // Ensure each driver in the team is properly linked
    if (team.getDrivers() != null) {
        team.getDrivers().forEach(driver -> driver.setTeam(team));
    }
    return teamService.save(team);
}


    @PutMapping("/{id}")
    public ResponseEntity<TeamEntity> updateTeam(@PathVariable Long id, @RequestBody TeamEntity team) {
        if (teamService.findById(id).isPresent()) {
            team.setTeam_id(id);
            return ResponseEntity.ok(teamService.save(team));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        if (teamService.findById(id).isPresent()) {
            teamService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
