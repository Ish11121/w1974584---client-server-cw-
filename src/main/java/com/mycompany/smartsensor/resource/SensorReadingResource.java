
package com.mycompany.smartsensor.resource;

import com.mycompany.smartsensor.dao.MockDatabase;
import com.mycompany.smartsensor.model.Sensor;
import com.mycompany.smartsensor.model.SensorReading;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class SensorReadingResource {

    private int sensorId;

    public SensorReadingResource(int sensorId) {
        this.sensorId = sensorId;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReadingInfo() {

        Sensor foundSensor = null;
        for (Sensor sensor : MockDatabase.SENSORS) {
            if (sensor.getSensorId() == sensorId) {
                foundSensor = sensor;
                break;
            }
        }

        if (foundSensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor not found")
                    .build();
        }

        List<SensorReading> sensorInfo = new ArrayList<>();

        for (SensorReading reading : MockDatabase.READINGS) {
            if (reading.getSensorId() == sensorId) {
                sensorInfo.add(reading);
            }
        }

        return Response.ok(sensorInfo).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReading(SensorReading reading) {

        Sensor foundSensor = null;
        for (Sensor sensor : MockDatabase.SENSORS) {
            if (sensor.getSensorId() == sensorId) {
                foundSensor = sensor;
                break;
            }
        }

        if (foundSensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Sensor has not been found")
                    .build();
        }

        int maxId = 0;
        for (SensorReading existingReading : MockDatabase.READINGS) {
            if (existingReading.getReadingId() > maxId) {
                maxId = existingReading.getReadingId();
            }
        }

        reading.setReadingId(maxId + 1);
        reading.setSensorId(sensorId);
        MockDatabase.READINGS.add(reading);

        foundSensor.setCurrentValue(reading.getValue());

        return Response.status(Response.Status.CREATED)
                .entity(reading)
                .build();
    }
}
