package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Path("registry/devices")
//@Path("registry/devices/{deviceId}/status")
public class RegistrationApi extends HttpServlet {

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
    @Inject
    private GetDeviceStatusQuery getDeviceCurrentStateQuery;
    @Inject
    private UpdateDeviceStatusUseCase updateDeviceStatusUseCase;
    @Inject
    private ToDeviceCurrentStateTypeMapper toDeviceCurrentStateMapper;
    @Inject
    private ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
    }


//    @Inject
//    UriInfo uriInfo;

//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response getRegisteredDevices() {
//        List<DeviceRegistration> deviceRegistrations = getRegisteredDeviceQuery.getDevice();
//        List<DeviceRegistrationType> deviceRegistrationTypes = deviceRegistrations
//                .stream()
//                .map(dr -> toDeviceRegistrationTypeMapper.map(dr, uriInfo))
//                .toList();
//        return Response.ok().entity(deviceRegistrationTypes).build();
//    }
//
//    @GET
//    @Path("{deviceId}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response getRegisteredDeviceInfo(@PathParam("deviceId") String deviceId) {
//        DeviceRegistrationType deviceRegistrationType = toDeviceRegistrationTypeMapper
//                .map(getRegisteredDeviceQuery.getDevice(new GetRegisteredDeviceCommand(deviceId)), uriInfo);
//        return Response.ok().entity(deviceRegistrationType).build();
//    }
//
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response registerDevice(DeviceRegistrationType deviceRegistrationType) {
//        RegisterDeviceCommand registerDeviceCommand = new RegisterDeviceCommand(
//                deviceRegistrationType.getDeviceId(),
//                deviceRegistrationType.getDeviceType(),
//                deviceRegistrationType.getDeviceUri(),
//                deviceRegistrationType.getStatusUpdatePeriod(),
//                deviceRegistrationType.getDeviceTags());
//        DeviceRegistrationType registered = toDeviceRegistrationTypeMapper
//                .map(registerDeviceUseCase.register(registerDeviceCommand), uriInfo);
//        return Response.ok().entity(registered).build();
//    }
//
//    @PUT
//    @Path("{deviceId}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response updateRegisteredDeviceInfo(@PathParam("deviceId") String deviceId,
//                                               DeviceRegistrationType deviceRegistrationType) {
//        UpdateDeviceRegistrationCommand updateDeviceRegistrationCommand = new UpdateDeviceRegistrationCommand(
//                deviceId,
//                deviceRegistrationType.getDeviceId(),
//                deviceRegistrationType.getDeviceType(),
//                deviceRegistrationType.getDeviceUri(),
//                deviceRegistrationType.getStatusUpdatePeriod(),
//                deviceRegistrationType.getDeviceTags());
//        DeviceRegistrationType updated = toDeviceRegistrationTypeMapper
//                .map(updateDeviceRegistrationUseCase.updateDeviceRegistration(updateDeviceRegistrationCommand), uriInfo);
//        return Response.ok().entity(updated).build();
//    }
//
//    @DELETE
//    @Path("{deviceId}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response deleteRegisteredDevice(@PathParam("deviceId") String deviceId) {
//        deleteReisteredDevicesUseCase.deleteRegisteredDevice(new DeleteRegisteredDeviceCommand(deviceId));
//        return Response.ok().build();
//    }

//

 //  These methods (getDeviceStatus, updateDeviceStatus) are from dev.sergevas.cg.gateway.registry.adapter.in.web.api.StatusApi
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response getDeviceStatus(@PathParam("deviceId") String deviceId) {
//        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
//                .map(this.getDeviceCurrentStateQuery.getDeviceStatus(new GetDeviceStatusCommand(deviceId)), uriInfo);
//        return Response.ok().entity(currentStateType).build();
//    }
//
//    @PUT
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response updateDeviceStatus(@PathParam("deviceId") String deviceId, DeviceStateType stateType) {
//        UpdateDeviceStatusCommand updateDeviceStatusCommand = this.toUpdateDeviceStatusCommandMapper.map(deviceId, stateType);
//        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
//                .map(this.updateDeviceStatusUseCase.updateDeviceStatus(updateDeviceStatusCommand), uriInfo);
//        return Response.ok().entity(currentStateType).build();
//    }
}
