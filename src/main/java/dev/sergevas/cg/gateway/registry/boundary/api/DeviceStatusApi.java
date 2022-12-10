package dev.sergevas.cg.gateway.registry.boundary.api;

import dev.sergevas.cg.gateway.registry.boundary.model.DeviceCurrentStateType;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("devices/status")
public class DeviceStatusApi {

    @GET
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
        return Response.ok().entity("magic!").build();
    }

    @PUT
    @Path("{deviceId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDeviceStatus( @PathParam("deviceId") String deviceId, @Valid DeviceCurrentStateType currentState) {
        return Response.ok().entity("magic!").build();
    }
}
