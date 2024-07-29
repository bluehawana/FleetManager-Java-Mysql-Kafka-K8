package com.bluehawana.service;

import com.bluehawana.entity.VehicleStatus;
import com.bluehawana.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {
    private final VehicleStatusRepository vehicleStatusRepository;

    @Autowired
    public VehicleStatusServiceImpl(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    @Override
    public List<VehicleStatus> findAllVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    @Override
    public VehicleStatus findVehicleStatusById(Long id) {
        return vehicleStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<VehicleStatus> findVehicleStatusByVehicleId(Long vehicleId) {
        return vehicleStatusRepository.findByVehicleId(vehicleId);
    }

    @Override
    public VehicleStatus saveVehicleStatus(VehicleStatus vehicleStatus) {
        return vehicleStatusRepository.save(vehicleStatus);
    }

    @Override
    public void deleteVehicleStatusById(Long id) {
        vehicleStatusRepository.deleteById(id);
    }

    @Override
    public void deleteAllVehicleStatuses() {
        vehicleStatusRepository.deleteAll();
    }
}