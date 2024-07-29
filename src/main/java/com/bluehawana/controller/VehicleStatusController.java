package com.bluehawana.controller;

import com.bluehawana.entity.VehicleStatus;
import com.bluehawana.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicle-statuses")
public class VehicleStatusController {
    private final VehicleStatusService vehicleStatusService;

    @Autowired
    public VehicleStatusController(VehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping
    public List<VehicleStatus> getAllVehicleStatuses() {
        return vehicleStatusService.findAllVehicleStatuses();
    }

    @GetMapping("/{id}")
    public VehicleStatus getVehicleStatusById(@PathVariable Long id) {
        return vehicleStatusService.findVehicleStatusById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<VehicleStatus> getVehicleStatusesByVehicleId(@PathVariable Long vehicleId) {
        return vehicleStatusService.findVehicleStatusByVehicleId(vehicleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleStatus createVehicleStatus(@RequestBody VehicleStatus vehicleStatus) {
        return vehicleStatusService.saveVehicleStatus(vehicleStatus);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicleStatus(@PathVariable Long id) {
        vehicleStatusService.deleteVehicleStatusById(id);
    }
}
