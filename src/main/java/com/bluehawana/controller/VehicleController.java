package com.bluehawana.controller;

import com.bluehawana.dto.VehicleStatusUpdateDTO;
import com.bluehawana.entity.Vehicle;
import com.bluehawana.entity.VehicleStatus;
import com.bluehawana.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        vehicle.setId(id);
        return vehicleService.save(vehicle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteById(id);
    }

    @PostMapping("/{vin}/status")
    public ResponseEntity<?> updateVehicleStatus(@PathVariable String vin, @RequestBody VehicleStatusUpdateDTO statusUpdate) {
        try {
            vehicleService.updateVehicleStatus(vin, statusUpdate);
            return ResponseEntity.ok("Vehicle status updated and event sent to Kafka");
        } catch (Exception e) {
            log.error("Error updating vehicle status for VIN: " + vin, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating vehicle status: " + e.getMessage());
        }
    }
}