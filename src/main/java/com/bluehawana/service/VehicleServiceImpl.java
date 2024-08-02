package com.bluehawana.service;

import com.bluehawana.entity.Vehicle;
import com.bluehawana.entity.VehicleStatus;
import com.bluehawana.event.VehicleStatusEvent;
import com.bluehawana.repository.VehicleRepository;
import com.bluehawana.repository.VehicleStatusRepository;
import com.bluehawana.dto.VehicleStatusUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final KafkaProducerService kafkaProducerService;
    private final VehicleStatusRepository vehicleStatusRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, KafkaProducerService kafkaProducerService, VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleRepository = vehicleRepository;
        this.kafkaProducerService = kafkaProducerService;
        this.vehicleStatusRepository = vehicleStatusRepository;
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

    @Override
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        vehicleRepository.deleteAll();
    }

    @Override
    public void updateVehicleStatus(String vin, VehicleStatus status) {
        Vehicle vehicle = vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with VIN: " + vin));

        status.setVehicle(vehicle);
        vehicle.getVehicleStatuses().add(status);

        vehicleRepository.save(vehicle);

        VehicleStatusEvent event = new VehicleStatusEvent();
        event.setVin(vin);
        event.setLatitude(status.getLatitude());
        event.setLongitude(status.getLongitude());
        event.setSpeed(status.getSpeed());
        event.setFuelLevel(status.getFuelLevel());
        event.setEngineStatus(status.getEngineStatus());
        event.setTimestamp(status.getTimestamp());

        kafkaProducerService.sendVehicleStatusUpdate(event);
    }

    @Override
    public void updateVehicleStatus(String vin, VehicleStatusUpdateDTO statusUpdate) {
        Vehicle vehicle = vehicleRepository.findByVin(vin)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with VIN: " + vin));

        VehicleStatus status = new VehicleStatus();
        status.setVehicle(vehicle);
        status.setLatitude(statusUpdate.getLatitude());
        status.setLongitude(statusUpdate.getLongitude());
        status.setSpeed(statusUpdate.getSpeed());
        status.setFuelLevel(statusUpdate.getFuelLevel());
        status.setEngineStatus(statusUpdate.getEngineStatus());
        status.setTimestamp(System.currentTimeMillis());

        // Save the new status
        vehicleStatusRepository.save(status);

        VehicleStatusEvent event = new VehicleStatusEvent();
        event.setVin(vin);
        event.setLatitude(status.getLatitude());
        event.setLongitude(status.getLongitude());
        event.setSpeed(status.getSpeed());
        event.setFuelLevel(status.getFuelLevel());
        event.setEngineStatus(status.getEngineStatus());
        event.setTimestamp(status.getTimestamp());

        kafkaProducerService.sendVehicleStatusUpdate(event);
    }
}