package com.f1.tracker.entity;

import com.f1.tracker.entity.TeamEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private Integer wins;
    private Integer championships;
}

