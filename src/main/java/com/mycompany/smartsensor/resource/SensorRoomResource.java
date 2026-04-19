
package com.mycompany.smartsensor.resource;

import com.mycompany.smartsensor.dao.MockDatabase;
import com.mycompany.smartsensor.model.Room;
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;


@Path("/rooms")
public class SensorRoomResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        return MockDatabase.ROOMS();
    
    }
    
    
    
    
   
}
