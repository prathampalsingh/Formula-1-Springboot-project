package com.f1.tracker.controller;

import com.f1.tracker.entity.DriverEntity;
import com.f1.tracker.entity.TeamEntity;
import com.f1.tracker.service.DriverService;
import com.f1.tracker.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;
    private final TeamService teamService;

    public DriverController(DriverService driverService, TeamService teamService) {
        this.driverService = driverService;
        this.teamService = teamService;
    }

    @GetMapping
    public List<DriverEntity> getAllDrivers() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getDriverById(@PathVariable Long id) {
        return driverService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createDriver")
    public ResponseEntity<DriverEntity> createDriver(@RequestBody DriverEntity driver) {
        // Fetch the TeamEntity using the provided team_id
        Long teamId = driver.getTeam().getTeam_id(); // Get team_id from the request body
        Optional<TeamEntity> team = teamService.findById(teamId);

        if (team.isPresent()) {
            // If team is found, set it on the driver
            driver.setTeam(team.get());
            DriverEntity savedDriver = driverService.save(driver);
            return ResponseEntity.ok(savedDriver); // Return the saved driver
        } else {
            // If team not found, return a bad request response
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverEntity> updateDriver(@PathVariable Long id, @RequestBody DriverEntity driver) {
        if (driverService.findById(id).isPresent()) {
            driver.setDriver_id(id);
            return ResponseEntity.ok(driverService.save(driver));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        if (driverService.findById(id).isPresent()) {
            driverService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
