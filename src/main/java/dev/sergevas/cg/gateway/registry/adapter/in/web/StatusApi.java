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
class StatusApi {

    private final GetDeviceStatusQuery getDeviceCurrentStateQuery;
    private final UpdateDeviceStatusUseCase updateDeviceStatusUseCase;
    private final ToDeviceCurrentStateTypeMapper deviceCurrentStateMapper;
    private final ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper;

    @Inject
    StatusApi(GetDeviceStatusQuery getDeviceCurrentStateQuery,
              UpdateDeviceStatusUseCase updateDeviceStatusUseCase,
              ToDeviceCurrentStateTypeMapper deviceCurrentStateMapper,
              ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper) {
        this.getDeviceCurrentStateQuery = getDeviceCurrentStateQuery;
        this.updateDeviceStatusUseCase = updateDeviceStatusUseCase;
        this.deviceCurrentStateMapper = deviceCurrentStateMapper;
        this.toUpdateDeviceStatusCommandMapper = toUpdateDeviceStatusCommandMapper;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
        DeviceCurrentStateType currentStateType = this.deviceCurrentStateMapper
                .map(this.getDeviceCurrentStateQuery
                        .getDeviceStatus(new GetDeviceStatusCommand(deviceId)));
        return Response.ok().entity(currentStateType).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDeviceStatus(@PathParam("deviceId") String deviceId, DeviceCurrentStateType currentState) {
        UpdateDeviceStatusCommand updateDeviceStatusCommand = this.toUpdateDeviceStatusCommandMapper.map(deviceId, currentState);
        DeviceCurrentStateType currentStateType = this.deviceCurrentStateMapper
                .map(this.updateDeviceStatusUseCase.updateDeviceStatus(updateDeviceStatusCommand));
        return Response.ok().entity(currentStateType).build();
    }
}
