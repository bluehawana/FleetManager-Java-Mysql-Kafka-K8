package com.bluehawana.service;

import com.bluehawana.event.VehicleStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, VehicleStatusEvent> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, VehicleStatusEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendVehicleStatusUpdate(VehicleStatusEvent event) {
        kafkaTemplate.send("vehicle-status-updates", event.getVin(), event);
    }
}
