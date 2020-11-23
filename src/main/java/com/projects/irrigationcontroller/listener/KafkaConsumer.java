package com.projects.irrigationcontroller.listener;

import com.projects.irrigationcontroller.model.Zone;
import com.projects.irrigationcontroller.service.IrrigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Ryan G. Marcoux
 */

@Service
public class KafkaConsumer {

    @Autowired
    private IrrigationService irrigationService;

    @KafkaListener(topics = "Zone_trigger", groupId = "group_json",
            containerFactory = "zoneContainerFactory")
    public void initiateZone(Zone zone) throws InterruptedException {
        irrigationService.toggleZoneWithTime(zone.getZoneNumber(), zone.getRunTimeInMinutes());
    }
}
