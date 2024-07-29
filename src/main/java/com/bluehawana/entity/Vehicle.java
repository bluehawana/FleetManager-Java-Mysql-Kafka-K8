package com.bluehawana.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other vehicle-related fields, such as:
    private String make;
    private String model;
    private String licensePlate;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleStatus> vehicleStatuses;

    public void setId(Long id) {

    }

    // Constructors, getters, and setters
}