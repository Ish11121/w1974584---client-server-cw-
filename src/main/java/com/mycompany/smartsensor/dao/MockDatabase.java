
package com.mycompany.smartsensor.dao;

import com.mycompany.smartsensor.model.Room;
import java.util.ArrayList;
import java.util.List;


public class MockDatabase {
    public static final List<Room> ROOMS = new ArrayList<>();
    
    static {
        ROOMS.add(new Room(1, "Room A", "Marylebone" ));
        ROOMS.add(new Room(2, "Room B", "Cavendish" ));
        ROOMS.add(new Room(3, "Room C", "Copland" ));
        
    }
       
}
