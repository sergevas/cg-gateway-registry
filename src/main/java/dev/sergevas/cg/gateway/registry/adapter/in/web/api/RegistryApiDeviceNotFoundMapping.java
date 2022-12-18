package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiDeviceNotFoundMapping implements ExceptionMapper<DeviceNotFoundException> {
    @Override
    public Response toResponse(DeviceNotFoundException e) {
        Error error = new Error()
                .errorCode("C-0001")
                .errorMsg(e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
