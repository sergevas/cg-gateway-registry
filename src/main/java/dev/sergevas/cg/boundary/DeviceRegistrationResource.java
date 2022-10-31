package dev.sergevas.cg.boundary;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class DeviceRegistrationResource {

    @Path("/{deviceId}/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DeviceRegistrationTypeResponse register(@PathParam("deviceId") String deviceId) {
        DeviceRegistrationTypeResponse response = null;
        return null;
    }

}
