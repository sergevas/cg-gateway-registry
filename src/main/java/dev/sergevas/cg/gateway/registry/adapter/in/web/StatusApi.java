package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusQuery;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("registry/devices/{deviceId}/status")
public class StatusApi {
    @Inject
    private GetDeviceStatusQuery getDeviceCurrentStateQuery;
    @Inject
    private UpdateDeviceStatusUseCase updateDeviceStatusUseCase;
    @Inject
    private ToDeviceCurrentStateTypeMapper toDeviceCurrentStateMapper;
    @Inject
    private ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
        DeviceStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.getDeviceCurrentStateQuery.getDeviceStatus(new GetDeviceStatusCommand(deviceId)));
        return Response.ok().entity(currentStateType).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDeviceStatus(@PathParam("deviceId") String deviceId, DeviceStateType stateType) {
        UpdateDeviceStatusCommand updateDeviceStatusCommand = this.toUpdateDeviceStatusCommandMapper.map(deviceId, stateType);
        DeviceStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.updateDeviceStatusUseCase.updateDeviceStatus(updateDeviceStatusCommand));
        return Response.ok().entity(currentStateType).build();
    }
}
