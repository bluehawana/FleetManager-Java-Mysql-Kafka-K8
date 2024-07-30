package com.bluehawana.service;

import com.bluehawana.entity.Vehicle;
import com.bluehawana.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return saveIfNotExists(vehicle);
    }

    @Override
    public Vehicle saveIfNotExists(Vehicle vehicle) {
        return vehicleRepository.findByVin(vehicle.getVin())
                .orElseGet(() -> vehicleRepository.save(vehicle));
    }

    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }

    public void deleteAll() {
        vehicleRepository.deleteAll();
    }
}