package dev.sergevas.cg.gateway.registry.adapter.in.web;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiRuntimeErrorMapping implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException re) {
        Error error = new Error()
                .errorCode("E-0001")
                .errorMsg(new StringBuilder("Runtime error: [")
                        .append(re.getMessage())
                        .append("]")
                        .toString());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
