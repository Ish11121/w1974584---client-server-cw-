
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
        return MockDatabase.ROOMS;
    
    }
    
    @GET
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomById(@PathParam("roomId") int roomId) {
        for (Room room : MockDatabase.ROOMS) {
            if (room.getRoomId() == roomId){
                return Response.ok(room).build();
            
            }
        
        }
        
        return Response.status(Response.Status.NOT_FOUND)
                .entity("This room is not known")
                .build();
    
    
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(Room room) {
        int maxId = 0;
        
        for (Room madeRoom : MockDatabase.ROOMS ){
            if (madeRoom.getRoomId() > maxId){
                maxId = madeRoom.getRoomId();
                    
                    }
        }
        
        room.setRoomId(maxId + 1);
        MockDatabase.ROOMS.add(room);
        
        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
   
}
