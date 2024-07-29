package com.bluehawana.repository;

import com.bluehawana.entity.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    List<VehicleStatus> findByVehicleId(Long vehicleId);
}
