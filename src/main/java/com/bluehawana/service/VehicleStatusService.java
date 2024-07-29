package com.bluehawana.service;

import com.bluehawana.entity.VehicleStatus;
import java.util.List;

public interface VehicleStatusService {
    List<VehicleStatus> findAllVehicleStatuses();
    VehicleStatus findVehicleStatusById(Long id);
    List<VehicleStatus> findVehicleStatusByVehicleId(Long vehicleId);
    VehicleStatus saveVehicleStatus(VehicleStatus vehicleStatus);
    void deleteVehicleStatusById(Long id);
    void deleteAllVehicleStatuses();
}
