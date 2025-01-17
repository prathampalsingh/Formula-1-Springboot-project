package com.f1.tracker.repository;

import com.f1.tracker.entity.RaceResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceResultRepository extends JpaRepository<RaceResultEntity, Long> {}

