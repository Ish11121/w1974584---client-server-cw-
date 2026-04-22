
package com.mycompany.smartsensor.model;


public class SensorReading {
    
    private int readingId;
    private int sensorId;
    private double value;
    private String timestamp;
    
    public SensorReading() {}
         
    public SensorReading(int readingId, int sensorId, double value, String timestamp){
        this.readingId = readingId;
        this.sensorId = sensorId;
        this.value = value;
        this.timestamp = timestamp;
        
    
    }

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String gettimestamp() {
        return timestamp;
    }

    public void settimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
    
    
    
}
