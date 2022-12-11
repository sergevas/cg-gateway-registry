package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceCurrentStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceCurrentStatusQuery;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("registry/devices/status")
class DeviceStatusApi {

    final GetDeviceCurrentStatusQuery getDeviceCurrentStateQuery;
    final DeviceCurrentStateMapper deviceCurrentStateMapper;

    @Inject
    DeviceStatusApi(GetDeviceCurrentStatusQuery getDeviceCurrentStateQuery, DeviceCurrentStateMapper deviceCurrentStateMapper) {
        this.getDeviceCurrentStateQuery = getDeviceCurrentStateQuery;
        this.deviceCurrentStateMapper = deviceCurrentStateMapper;
    }

    @GET
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
        DeviceCurrentStateType currentStateType = this.deviceCurrentStateMapper
                .toDeviceCurrentStateType(this.getDeviceCurrentStateQuery
                        .getDeviceCurrentStatus(new DeviceCurrentStatusCommand(deviceId)));
        return Response.ok().entity(currentStateType).build();
    }

    @PUT
    @Path("{deviceId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDeviceStatus(@PathParam("deviceId") String deviceId, @Valid DeviceCurrentStateType currentState) {
        return Response.ok().entity("magic!").build();
    }
}
