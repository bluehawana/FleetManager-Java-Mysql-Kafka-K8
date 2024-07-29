package com.bluehawana.service;

import com.bluehawana.entity.Vehicle;
import java.util.List;


public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    Vehicle save(Vehicle vehicle);
    void deleteById(Long id);
    void deleteAll();
}
