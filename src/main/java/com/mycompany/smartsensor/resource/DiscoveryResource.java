/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartsensor.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getApiInfo() {
        return "{ \"version\": \"version one\", \"contact\": \"admin@westminster.ac.uk\", \"resources\": { \"rooms\": \"/api/v1/rooms\", \"sensors\": \"/api/v1/sensors\" } }";
    }
}