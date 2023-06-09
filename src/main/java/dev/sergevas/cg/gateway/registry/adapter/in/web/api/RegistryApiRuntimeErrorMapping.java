package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiRuntimeErrorMapping implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {
        Error error = new Error()
                .errorCode("E-0001")
                .errorMsg("Runtime error: [" +
                        e.getMessage() +
                        "]");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
