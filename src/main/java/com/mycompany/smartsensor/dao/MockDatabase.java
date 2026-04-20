
package com.mycompany.smartsensor.dao;

import com.mycompany.smartsensor.model.Room;
import com.mycompany.smartsensor.model.Sensor;
import java.util.ArrayList;
import java.util.List;


public class MockDatabase {
    public static final List<Room> ROOMS = new ArrayList<>();
    public static final List<Sensor> SENSORS = new ArrayList<>();

    
    static {
        ROOMS.add(new Room(1, "Room A", "Marylebone" ));
        ROOMS.add(new Room(2, "Room B", "Cavendish" ));
        ROOMS.add(new Room(3, "Room C", "Copland" ));
        
        
        SENSORS.add(new Sensor(1, "Temp Sensor", 1));
        SENSORS.add(new Sensor(2, "CO Sensor", 2));
        SENSORS.add(new Sensor(3, "Smoke Sensor", 3));


        
    }
       
}
