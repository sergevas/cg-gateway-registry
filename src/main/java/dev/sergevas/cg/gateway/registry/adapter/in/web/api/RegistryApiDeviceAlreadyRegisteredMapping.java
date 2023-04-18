package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceAlreadyRegisteredException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiDeviceAlreadyRegisteredMapping implements ExceptionMapper<DeviceAlreadyRegisteredException> {
    @Override
    public Response toResponse(DeviceAlreadyRegisteredException e) {
        Error error = new Error()
                .errorCode("C-0002")
                .errorMsg(e.getMessage());
        return Response
                .status(Response.Status.CONFLICT)
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
