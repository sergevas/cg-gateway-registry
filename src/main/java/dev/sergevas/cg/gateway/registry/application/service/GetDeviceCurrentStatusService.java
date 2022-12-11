package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceCurrentStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceCurrentStatusQuery;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GetDeviceCurrentStatusService implements GetDeviceCurrentStatusQuery {
    @Override
    public DeviceState getDeviceCurrentStatus(DeviceCurrentStatusCommand deviceCurrentStatusCommand) {
        return null;
    }
}
