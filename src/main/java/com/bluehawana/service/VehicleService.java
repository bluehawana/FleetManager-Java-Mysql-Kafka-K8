package com.bluehawana.service;

import com.bluehawana.dto.VehicleStatusUpdateDTO;
import com.bluehawana.entity.Vehicle;
import com.bluehawana.entity.VehicleStatus;

import java.util.List;


public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    Vehicle saveIfNotExists(Vehicle vehicle);

    Vehicle save(Vehicle vehicle);

    void deleteById(Long id);
    void deleteAll();

    void updateVehicleStatus(String vin, VehicleStatus status);

    void updateVehicleStatus(String vin, VehicleStatusUpdateDTO statusUpdate);
}
