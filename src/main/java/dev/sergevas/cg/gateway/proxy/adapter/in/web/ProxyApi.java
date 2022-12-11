package dev.sergevas.cg.gateway.proxy.adapter.in.web;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("proxy/devices")
public class ProxyApi {

    @GET
    @Path("/{deviceId}/{deviceResource}")
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    public Response getOnDeviceResource(@PathParam("deviceId") String deviceId,
                                        @PathParam("deviceResource") String deviceResource) {
        return Response.ok().entity("magic!").build();
    }

    @POST
    @Path("/{deviceId}/{deviceResource}")
    @Consumes({MediaType.APPLICATION_OCTET_STREAM})
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    public Response postOnDeviceResource(@PathParam("deviceId") String deviceId,
                                         @PathParam("deviceResource") String deviceResource,
                                         @Valid Object body) {
        return Response.ok().entity("magic!").build();
    }
}
