package com.f1.tracker.service;

import com.f1.tracker.entity.*;
import com.f1.tracker.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<RaceEntity> findAll() {
        return raceRepository.findAll();
    }

    public Optional<RaceEntity> findById(Long id) {
        return raceRepository.findById(id);
    }

    public RaceEntity save(RaceEntity race) {
        return raceRepository.save(race);
    }

    public void deleteById(Long id) {
        raceRepository.deleteById(id);
    }
}
