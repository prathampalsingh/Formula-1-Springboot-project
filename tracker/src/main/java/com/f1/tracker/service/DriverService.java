package com.f1.tracker.service;

import com.f1.tracker.entity.*;
import com.f1.tracker.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<DriverEntity> findAll() {
        return driverRepository.findAll();
    }

    public Optional<DriverEntity> findById(Long id) {
        return driverRepository.findById(id);
    }

    public DriverEntity save(DriverEntity driver) {
        return driverRepository.save(driver);
    }

    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }
}
