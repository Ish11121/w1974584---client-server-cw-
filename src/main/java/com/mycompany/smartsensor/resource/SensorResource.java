
package com.mycompany.smartsensor.resource;

import com.mycompany.smartsensor.dao.MockDatabase;
import com.mycompany.smartsensor.model.Room;
import com.mycompany.smartsensor.model.Sensor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

@Path("/sensors")
public class SensorResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getALLSensors() {
        return MockDatabase.SENSORS;
    
    }
    
    @GET
    @Path("/{sensorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSensorById(@PathParam("sensorId")int sensorId){
        for (Sensor sensor : MockDatabase.SENSORS) {
            if (sensor.getSensorId() == sensorId) {
                return Response.ok(sensor).build();
            
            }
            
        }
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Sensor has not been found")
                .build();
            
    }    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor sensor) {
        Room findRoom = null;
        for (Room room : MockDatabase.ROOMS){
            if (room.getRoomId() == sensor.getRoomId()){
                findRoom = room;
                break;
                
                
            
            }
        }
        
        if (findRoom == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Room no exist")
                    .build();
        
        }
        
        int maxId = 0;
        for (Sensor s : MockDatabase.SENSORS){
            if (s.getSensorId()>maxId){
                maxId = s.getSensorId();
            }
        
        }
        
        sensor.setSensorId(maxId + 1 );
        MockDatabase.SENSORS.add(sensor);
        return Response.status(Response.Status.CREATED)
                .entity(sensor)
                .build();
            
          
    }
    
}
        
        
        
    
    