package com.f1.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;

    private String name;
    private String nationality;
    private int age;
    private int wins;
    private int championships;

    // Many-to-one relationship with the TeamEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false) // team_id in DriverEntity references team_id in TeamEntity
    private TeamEntity team; // This field links the driver to the team

}
