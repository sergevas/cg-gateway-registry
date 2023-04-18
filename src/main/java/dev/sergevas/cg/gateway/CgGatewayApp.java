package dev.sergevas.cg.gateway;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("gateway")
public class CgGatewayApp extends Application {
}
