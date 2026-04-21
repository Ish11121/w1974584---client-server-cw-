
package com.mycompany.smartsensor.model;


public class SensorReading {
    
    private int readingId;
    private int sensorId;
    private double value;
    private String TimeDate;
    
    public SensorReading() {}
         
    public SensorReading(int readingId, int sensorId, double value, String TimeDate){
        this.readingId = readingId;
        this.sensorId = sensorId;
        this.value = value;
        this.TimeDate = TimeDate;
        
    
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

    public String getTimeDate() {
        return TimeDate;
    }

    public void setTimeDate(String TimeDate) {
        this.TimeDate = TimeDate;
    }
    
    
    
    
    
    
}
