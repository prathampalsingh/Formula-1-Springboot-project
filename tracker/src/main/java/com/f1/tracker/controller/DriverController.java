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
    if (driver.getTeam() == null || driver.getTeam().getTeam_id() == null) {
        return ResponseEntity.badRequest().body(null); // Ensure team is provided
    }

    Optional<TeamEntity> team = teamService.findById(driver.getTeam().getTeam_id());
    if (team.isPresent()) {
        driver.setTeam(team.get());
        DriverEntity savedDriver = driverService.save(driver);
        return ResponseEntity.ok(savedDriver);
    } else {
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
