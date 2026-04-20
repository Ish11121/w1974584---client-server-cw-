/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartsensor.model;

/**
 *
 * @author ishmam
 */
public class Sensor {
    
    private int sensorId;
    private String sensorName;
    private int roomId;
    
    public Sensor() {}
    
    public Sensor(int sensorId, String sensorName, int roomId) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.roomId = roomId;
        
    }
    
    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
}
