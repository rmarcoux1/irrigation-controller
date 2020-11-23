package com.projects.irrigationcontroller.controller;

import com.pi4j.io.gpio.*;
import com.projects.irrigationcontroller.service.IrrigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class GpioRestController {

    @Autowired
    private IrrigationService irrigationService;

    @RequestMapping("/zone/{zoneNumber}")
    public void toggleZone(@PathVariable String  zoneNumber) {
        irrigationService.toggleZone(zoneNumber);
    }

    @RequestMapping("/zone/{zoneNumber}/{runTime}")
    public void toggleZoneWithTime(@PathVariable String  zoneNumber, @PathVariable int runTime) throws InterruptedException {
        irrigationService.toggleZoneWithTime(zoneNumber,runTime);
    }
}
