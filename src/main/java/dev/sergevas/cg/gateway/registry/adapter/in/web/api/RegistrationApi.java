package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Path("registry/devices")
public class RegistrationApi extends HttpServlet {
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
//    private GetRegisteredDeviceQuery getRegisteredDeviceQuery;
//    @Inject
//    private ToDeviceRegistrationTypeMapper toDeviceRegistrationTypeMapper;
//    @Inject
//    private RegisterDeviceUseCase registerDeviceUseCase;
//    @Inject
//    private UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase;
//    @Inject
//    private DeleteReisteredDevicesUseCase deleteReisteredDevicesUseCase;
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
}
