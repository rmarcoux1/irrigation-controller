package com.projects.irrigationcontroller.model;

import java.time.ZonedDateTime;

/**
 * @author Ryan G. Marcoux
 */
public class Zone {

    private String zoneNumber;
    private int runTimeInMinutes;

    public Zone(String zoneNumber, int runTimeInMinutes) {
        this.zoneNumber = zoneNumber;
        this.runTimeInMinutes = runTimeInMinutes;
    }

    public Zone() {
        super();
    }

    public String getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(String zoneNumber) {
        this.zoneNumber = zoneNumber;
    }

    public int getRunTimeInMinutes() {
        return runTimeInMinutes;
    }

    public void setRunTimeInMinutes(int runTimeInMinutes) {
        this.runTimeInMinutes = runTimeInMinutes;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "zoneNumber='" + zoneNumber + '\'' +
                ", runTimeInMinutes=" + runTimeInMinutes +
                '}';
    }
}
