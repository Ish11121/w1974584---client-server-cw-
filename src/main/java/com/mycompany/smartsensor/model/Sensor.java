
package com.mycompany.smartsensor.model;


public class Sensor {
    
    private int sensorId;
    private String sensorName;
    private int roomId;
    private String type;
    
    public Sensor() {}
    
    public Sensor(int sensorId, String sensorName, String type, int roomId) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.roomId = roomId;
        this.type = type;
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
    
}
