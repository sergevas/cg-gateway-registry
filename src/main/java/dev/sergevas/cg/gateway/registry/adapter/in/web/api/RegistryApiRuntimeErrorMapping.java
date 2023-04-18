package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

@Provider
public class RegistryApiRuntimeErrorMapping implements ExceptionMapper<RuntimeException> {

    private static final Logger LOG = Logger.getLogger(RegistryApiRuntimeErrorMapping.class.getName());

    @Override
    public Response toResponse(RuntimeException e) {
        LOG.severe(e.toString());
        Error error = new Error()
                .errorCode("E-0001")
                .errorMsg(new StringBuilder("Runtime error: [")
                        .append(e.getMessage())
                        .append("]")
                        .toString());
        return Response
                .serverError()
                .type(MediaType.APPLICATION_JSON)
                .entity(error)
                .build();
    }
}
