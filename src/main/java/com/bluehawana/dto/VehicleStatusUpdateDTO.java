package com.bluehawana.dto;

import lombok.Data;

@Data
public class VehicleStatusUpdateDTO {
private double latitude;
private double longitude;
private double speed;
private double fuelLevel;
private String engineStatus;
}
