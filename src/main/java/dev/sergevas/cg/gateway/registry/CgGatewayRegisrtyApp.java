package dev.sergevas.cg.gateway.registry;

import dev.sergevas.cg.gateway.registry.boundary.api.DeviceStatusApi;
import dev.sergevas.cg.gateway.registry.boundary.api.DeviceRegistrationApi;
import dev.sergevas.cg.gateway.registry.boundary.api.StatusApi;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Set;

@ApplicationPath("registry")
public class CgGatewayRegisrtyApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(DeviceStatusApi.class, DeviceRegistrationApi.class, StatusApi.class);
    }
}
