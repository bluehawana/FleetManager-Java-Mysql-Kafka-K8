package com.bluehawana.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VehicleStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private double latitude;
    private double longitude;
    private double speed;
    private double fuelLevel;
    private String engineStatus;

    @Column(columnDefinition = "BIGINT")
    private long timestamp;

    // Constructors, getters, and setters
}