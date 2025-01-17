package com.f1.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "Teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;

    private String name;
    private String headquarters;
    private BigDecimal budget;
    private String carModel;

    // One-to-many relationship with DriverEntity
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DriverEntity> drivers; // This field maintains the list of drivers for the team

}
