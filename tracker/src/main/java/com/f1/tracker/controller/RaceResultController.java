package com.f1.tracker.controller;

import com.f1.tracker.entity.*;
import com.f1.tracker.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class RaceResultController {

    private final RaceResultService raceResultService;

    public RaceResultController(RaceResultService raceResultService) {
        this.raceResultService = raceResultService;
    }

    @GetMapping
    public List<RaceResultEntity> getAllResults() {
        return raceResultService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaceResultEntity> getResultById(@PathVariable Long id) {
        return raceResultService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createRaceResult")
    public RaceResultEntity createResult(@RequestBody RaceResultEntity result) {
        return raceResultService.save(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RaceResultEntity> updateResult(@PathVariable Long id, @RequestBody RaceResultEntity result) {
        if (raceResultService.findById(id).isPresent()) {
            result.setId(id);
            return ResponseEntity.ok(raceResultService.save(result));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        if (raceResultService.findById(id).isPresent()) {
            raceResultService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
