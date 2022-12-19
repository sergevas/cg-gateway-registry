package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.*;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.inject.Inject;
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
    @Inject
    private RegisterDeviceUseCase registerDeviceUseCase;
    @Inject
    private UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase;
    @Inject
    private DeleteReisteredDevicesUseCase deleteReisteredDevicesUseCase;

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
    public Response registerDevice(DeviceRegistrationType deviceRegistrationType) {
        RegisterDeviceCommand registerDeviceCommand = new RegisterDeviceCommand(
                deviceRegistrationType.getDeviceId(),
                deviceRegistrationType.getDeviceType(),
                deviceRegistrationType.getDeviceUri(),
                deviceRegistrationType.getStatusUpdatePeriod(),
                deviceRegistrationType.getDeviceTags());
        DeviceRegistrationType registered = toDeviceRegistrationTypeMapper
                .map(registerDeviceUseCase.register(registerDeviceCommand));
        return Response.ok().entity(registered).build();
    }

    @PUT
    @Path("{deviceId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateRegisteredDeviceInfo(@PathParam("deviceId") String deviceId,
                                               DeviceRegistrationType deviceRegistrationType) {
        UpdateDeviceRegistrationCommand updateDeviceRegistrationCommand = new UpdateDeviceRegistrationCommand(
                deviceId,
                deviceRegistrationType.getDeviceId(),
                deviceRegistrationType.getDeviceType(),
                deviceRegistrationType.getDeviceUri(),
                deviceRegistrationType.getStatusUpdatePeriod(),
                deviceRegistrationType.getDeviceTags());
        DeviceRegistrationType updated = toDeviceRegistrationTypeMapper
                .map(updateDeviceRegistrationUseCase.updateDeviceRegistration(updateDeviceRegistrationCommand));
        return Response.ok().entity(updated).build();
    }

    @DELETE
    @Path("{deviceId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteRegisteredDevice(@PathParam("deviceId") String deviceId) {
        DeviceRegistrationType deviceRegistrationType = toDeviceRegistrationTypeMapper
                .map(deleteReisteredDevicesUseCase.deleteRegisteredDevice(new DeleteRegisteredDeviceCommand(deviceId)));
        return Response.ok().entity(deviceRegistrationType).build();
    }
}
