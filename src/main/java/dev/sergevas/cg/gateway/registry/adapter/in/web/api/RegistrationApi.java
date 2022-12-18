package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceQuery;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("registry/devices")
public class RegistrationApi {

    @Inject
    private GetRegisteredDeviceQuery getRegisteredDeviceQuery;
    @Inject
    private ToDeviceRegistrationTypeMapper toDeviceRegistrationTypeMapper;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegisteredDevices() {
        List<DeviceRegistration> deviceRegistrations = getRegisteredDeviceQuery.getDevice();
        List<DeviceRegistrationType> deviceRegistrationTypes = deviceRegistrations
                .stream()
                .map(toDeviceRegistrationTypeMapper::map)
                .toList();
        return Response.ok().entity(deviceRegistrationTypes).build();
    }

    @GET
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRegisteredDeviceInfo(@PathParam("deviceId") String deviceId) {
        DeviceRegistrationType deviceRegistrationType = toDeviceRegistrationTypeMapper
                .map(getRegisteredDeviceQuery.getDevice(new GetRegisteredDeviceCommand(deviceId)));
        return Response.ok().entity(deviceRegistrationType).build();
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
    public Response updateRegisteredDeviceInfo(@PathParam("deviceId") String deviceId, @Valid DeviceRegistrationType body) {
        return Response.ok().entity("magic!").build();
    }

    @DELETE
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteRegisteredDevice(@PathParam("deviceId") String deviceId) {
        return Response.ok().entity("magic!").build();
    }
}
