package com.bluehawana.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class VehicleStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Timestamp timestamp;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private Double fuelLevel;
    private String engineStatus;

    @Column(name = "created_at")
    private Timestamp createdAt;

    // Constructors, getters, and setters
}
