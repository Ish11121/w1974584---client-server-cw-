
package com.mycompany.smartsensor.dao;

import com.mycompany.smartsensor.model.Room;
import com.mycompany.smartsensor.model.Sensor;
import com.mycompany.smartsensor.model.SensorReading;
import java.util.ArrayList;
import java.util.List;


public class MockDatabase {
    public static final List<Room> ROOMS = new ArrayList<>();
    public static final List<Sensor> SENSORS = new ArrayList<>();
    public static final List<SensorReading> READINGS = new ArrayList<>();


    
    static {
        ROOMS.add(new Room(1, "Room A", "Marylebone" ));
        ROOMS.add(new Room(2, "Room B", "Cavendish" ));
        ROOMS.add(new Room(3, "Room C", "Copland" ));
        
        
        SENSORS.add(new Sensor(1, "Temp Sensor", "Temperature", 1, 64));
        SENSORS.add(new Sensor(2, "CO Sensor", "CO2", 2, 65));
        SENSORS.add(new Sensor(3, "Smoke Sensor", "Smoke", 3, 66));
        
        READINGS.add(new SensorReading(1, 1, 67, "24/04/2026 @2am"));
        READINGS.add(new SensorReading(2, 1, 68, "24/04/2026 @4am"));
        READINGS.add(new SensorReading(3, 2, 69, "24/04/2026 @3am"));




        
    }
       
}
