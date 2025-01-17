package com.f1.tracker.service;

import com.f1.tracker.entity.*;
import com.f1.tracker.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RaceResultService {

    private final RaceResultRepository raceResultRepository;

    public RaceResultService(RaceResultRepository raceResultRepository) {
        this.raceResultRepository = raceResultRepository;
    }

    public List<RaceResultEntity> findAll() {
        return raceResultRepository.findAll();
    }

    public Optional<RaceResultEntity> findById(Long id) {
        return raceResultRepository.findById(id);
    }

    public RaceResultEntity save(RaceResultEntity raceResult) {
        return raceResultRepository.save(raceResult);
    }

    public void deleteById(Long id) {
        raceResultRepository.deleteById(id);
    }
}

