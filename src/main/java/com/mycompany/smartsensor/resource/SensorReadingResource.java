
package com.mycompany.smartsensor.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class SensorReadingResource {
    
    private int sensorId;
    
   
    public SensorReadingResource(int sensorId){
        this.sensorId = sensorId;
    
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tryReadings(){
        return sensorId + "working correctly";
    
    }
    
}
