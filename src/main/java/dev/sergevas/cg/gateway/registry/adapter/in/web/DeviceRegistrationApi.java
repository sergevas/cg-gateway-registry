package dev.sergevas.cg.gateway.registry.adapter.in.web;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("registry/devices")
public class DeviceRegistrationApi {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegisteredDevices() {
        return Response.ok().entity("magic!").build();
    }
    @GET
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegisteredDeviceInfo( @PathParam("deviceId") String deviceId) {
        return Response.ok().entity("magic!").build();
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response registerDevice(@Valid DeviceRegistrationType body) {
        return Response.ok().entity("magic!").build();
    }
    @PUT
    @Path("{deviceId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateRegisteredDeviceInfo( @PathParam("deviceId") String deviceId, @Valid DeviceRegistrationType body) {
        return Response.ok().entity("magic!").build();
    }
    @DELETE
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteRegisteredDevice( @PathParam("deviceId") String deviceId) {
        return Response.ok().entity("magic!").build();
    }
}
