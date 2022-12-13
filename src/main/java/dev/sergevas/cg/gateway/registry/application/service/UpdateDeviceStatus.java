package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import dev.sergevas.cg.gateway.registry.application.port.out.UpdateDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateDeviceStatus implements UpdateDeviceStatusUseCase {

    private UpdateDeviceState updateDeviceState;

    @Inject
    public UpdateDeviceStatus(UpdateDeviceState updateDeviceState) {
        this.updateDeviceState = updateDeviceState;
    }

    @Override
    public DeviceState updateDeviceStatus(UpdateDeviceStatusCommand updateDeviceStatusCommand) {
        return null;
    }
}
