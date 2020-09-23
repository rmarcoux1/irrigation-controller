package com.projects.irrigationcontroller.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class GpioRestController {

    // create gpio controller
    final GpioController gpio = GpioFactory.getInstance();

    // provision gpio pin #01 as an output pin and turn on
    final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW);

    @RequestMapping("/zone/{zoneNumber}")
    public void toggleZone(@PathVariable String  zoneNumber) {
        if (null != zoneNumber) {
            GpioPinDigitalOutput pinDigitalOutput = getZoneByInput(zoneNumber);
            if (null != pinDigitalOutput) {
                pinDigitalOutput.toggle();
            }
        }
    }

    @RequestMapping("/zone/{zoneNumber}/{runTime}")
    public void toggleZoneWithTime(@PathVariable String  zoneNumber, @PathVariable int runTime) throws InterruptedException {
        if (null != zoneNumber) {
            GpioPinDigitalOutput pinDigitalOutput = getZoneByInput(zoneNumber);
            if (null != pinDigitalOutput) {
                pinDigitalOutput.high();
                Thread.sleep(getZoneRunTime(runTime));
                pinDigitalOutput.low();
            }
        }
    }


    private int getZoneRunTime(int milliseconds) {
        return milliseconds * 1000 * 60;
    }

    private GpioPinDigitalOutput getZoneByInput(String zoneNumber) {

        GpioPinDigitalOutput pin = null;

        switch (zoneNumber) {
            case "1":
                pin =  pin1;
                break;
            case "2":
                pin =  pin2;
                break;
            case "3":
                pin =  pin3;
                break;
            case "4":
                pin =  pin4;
                break;
            case "5":
                pin =  pin5;
                break;
            case "6":
                pin =  pin6;
                break;
        }

        return pin;
    }
}
