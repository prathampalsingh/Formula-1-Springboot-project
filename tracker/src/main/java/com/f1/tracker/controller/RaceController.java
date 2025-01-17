package com.f1.tracker.controller;

import com.f1.tracker.entity.*;
import com.f1.tracker.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<RaceEntity> getAllRaces() {
        return raceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaceEntity> getRaceById(@PathVariable Long id) {
        return raceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createRace")
    public RaceEntity createRace(@RequestBody RaceEntity race) {
        return raceService.save(race);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RaceEntity> updateRace(@PathVariable Long id, @RequestBody RaceEntity race) {
        if (raceService.findById(id).isPresent()) {
            race.setId(id);
            return ResponseEntity.ok(raceService.save(race));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        if (raceService.findById(id).isPresent()) {
            raceService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
