package com.f1.tracker.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@Table(name = "Race")
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String track;
    private LocalDate date;

    // Option 1: Using a separate entity for results
    @OneToMany(mappedBy = "race")
    private List<RaceResultEntity> results; 
}
