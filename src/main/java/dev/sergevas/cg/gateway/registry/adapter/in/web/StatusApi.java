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

    public StatusApi() {
    }

    @Inject
    private GetDeviceStatusQuery getDeviceCurrentStateQuery;
    @Inject
    private  UpdateDeviceStatusUseCase updateDeviceStatusUseCase;
    @Inject
    private  ToDeviceCurrentStateTypeMapper toDeviceCurrentStateMapper;
    @Inject
    private  ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.getDeviceCurrentStateQuery
                        .getDeviceStatus(new GetDeviceStatusCommand(deviceId)));
        return Response.ok().entity(currentStateType).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateDeviceStatus(@PathParam("deviceId") String deviceId, DeviceCurrentStateType currentState) {
        UpdateDeviceStatusCommand updateDeviceStatusCommand = this.toUpdateDeviceStatusCommandMapper.map(deviceId, currentState);
        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.updateDeviceStatusUseCase.updateDeviceStatus(updateDeviceStatusCommand));
        return Response.ok().entity(currentStateType).build();
    }
}
