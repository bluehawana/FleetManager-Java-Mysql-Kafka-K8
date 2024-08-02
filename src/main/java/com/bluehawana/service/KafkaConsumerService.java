package com.bluehawana.service;

import com.bluehawana.event.VehicleStatusEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "vehicle-status-updates", groupId = "fleet-manager-group")
    public void consumeVehicleStatusUpdate(VehicleStatusEvent event) {
        System.out.println("Received vehicle status update: " + event);
        // Process the event (e.g., update in-memory cache, trigger notifications)
    }
}
