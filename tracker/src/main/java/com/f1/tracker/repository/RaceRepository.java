package com.f1.tracker.repository;

import com.f1.tracker.entity.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {}
