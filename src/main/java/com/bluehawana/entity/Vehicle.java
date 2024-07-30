package com.bluehawana.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String make;
    private String model;
    private String year;
    private String licensePlate;

    @Column(unique = true)
    private String vin;
}
