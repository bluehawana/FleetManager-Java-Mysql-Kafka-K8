package com.bluehawana.event;

import lombok.Data;

@Data
public class VehicleStatusEvent {
    private String vin;
    private double latitude;
    private double longitude;
    private double speed;
    private double fuelLevel;
    private String engineStatus;
    private long timestamp;
}
