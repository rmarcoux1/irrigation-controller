package com.projects.irrigationcontroller.service;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Service;

/**
 * @author Ryan G. Marcoux
 */
@Service
public class IrrigationService {

    // create gpio controller
    final GpioController gpio = GpioFactory.getInstance();

    // provision gpio pin #01 as an output pin and turn on
    final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "MyLED", PinState.LOW);
    final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED", PinState.LOW);

    public void toggleZone(String zoneNumber) {
        if (null != zoneNumber) {
            GpioPinDigitalOutput pinDigitalOutput = getZoneByInput(zoneNumber);
            if (null != pinDigitalOutput) {
                pinDigitalOutput.toggle();
            }
        }
    }

    public void toggleZoneWithTime(String  zoneNumber, int runTime) throws InterruptedException {
        if (null != zoneNumber) {
            GpioPinDigitalOutput pinDigitalOutput = getZoneByInput(zoneNumber);
            if (null != pinDigitalOutput) {
                pinDigitalOutput.high();
                System.out.println("Pin " + zoneNumber + " is on");
                Thread.sleep(getZoneRunTime(runTime));
                pinDigitalOutput.low();
                System.out.println("Pin " + zoneNumber + " is off");
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
            case "7":
                pin =  pin7;
                break;
            case "8":
                pin =  pin8;
                break;
        }

        return pin;
    }
}
