
package com.mycompany.smartsensor.model;


public class Sensor {
    
    private int sensorId;
    private String sensorName;
    private int roomId;
    private String type;
    private double currentValue;
    private String status;
    
    public Sensor() {}
    
    public Sensor(int sensorId, String sensorName, String type, int roomId, double currentValue, String status) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.roomId = roomId;
        this.type = type;
        this.currentValue = currentValue;
        this.status = status;
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
    
    public String getType(){
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    } 

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
}
