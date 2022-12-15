package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiDeviceNotFoundMapping implements ExceptionMapper<DeviceNotFoundException> {
    @Override
    public Response toResponse(DeviceNotFoundException dnfe) {
        Error error = new Error()
                .errorCode("E-0002")
                .errorMsg(new StringBuilder("Device Not Found: [")
                        .append(dnfe.getMessage())
                        .append("]")
                        .toString());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
