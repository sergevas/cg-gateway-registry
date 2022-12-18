package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegistryApiValidationErrorMapping implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException cve) {
        Error error = new Error()
                .errorCode("V-0001")
                .errorMsg(new StringBuilder("Validation error: [")
                        .append(cve.getMessage())
                        .append("]")
                        .toString());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
