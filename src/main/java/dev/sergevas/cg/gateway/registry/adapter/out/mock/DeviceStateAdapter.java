package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusQuery;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceStateAdapter implements GetDeviceStatusQuery, UpdateDeviceStatusUseCase {
    @Override
    public DeviceState getDeviceStatus(GetDeviceStatusCommand deviceCurrentStatusCommand) {
        return null;
    }

    @Override
    public DeviceState updateDeviceStatus(UpdateDeviceStatusCommand updateDeviceStatusCommand) {
        return null;
    }
}
