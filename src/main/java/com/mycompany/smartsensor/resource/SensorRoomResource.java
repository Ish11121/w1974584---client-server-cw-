
package com.mycompany.smartsensor.resource;

import com.mycompany.smartsensor.dao.MockDatabase;
import com.mycompany.smartsensor.model.Room;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;
import com.mycompany.smartsensor.model.Sensor;
import com.mycompany.smartsensor.exception.RoomNotEmptyException;


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
            if (room.getRoomId() == roomId) {
                return Response.ok(room).build();

            }

        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Room not found")
                .build();

    
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(Room room) {
        int maxId = 0;

        for (Room madeRoom : MockDatabase.ROOMS) {
            if (madeRoom.getRoomId() > maxId) {
                maxId = madeRoom.getRoomId();

            }
        }

        room.setRoomId(maxId + 1);
        MockDatabase.ROOMS.add(room);

        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
    }

    @DELETE
    @Path("/{roomId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRoom(@PathParam("roomId") int roomId) {

        for (Sensor sensor : MockDatabase.SENSORS) {
            if (sensor.getRoomId() == roomId) {
                throw new RoomNotEmptyException("Room is currently occupied by active hardware");
            }
        }

        for (int i = 0; i < MockDatabase.ROOMS.size(); i++) {
            Room room = MockDatabase.ROOMS.get(i);
            if (room.getRoomId() == roomId) {
                MockDatabase.ROOMS.remove(i);
                return Response.ok("Room deleted").build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Room not found")
                .build();
    }
}
