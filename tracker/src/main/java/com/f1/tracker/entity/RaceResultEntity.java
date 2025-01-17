package com.f1.tracker.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@Table(name = "RaceResults")
public class RaceResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private RaceEntity race;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    private Integer position;
}
