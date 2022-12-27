package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import dev.sergevas.cg.gateway.registry.application.port.out.UpdateDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@ApplicationScoped
public class UpdateDeviceStatusService implements UpdateDeviceStatusUseCase {

    private UpdateDeviceState updateDeviceState;

    @Inject
    public UpdateDeviceStatusService(UpdateDeviceState updateDeviceState) {
        this.updateDeviceState = updateDeviceState;
    }

    @Override
    public DeviceState updateDeviceStatus(UpdateDeviceStatusCommand updateDeviceStatusCommand) {
        DeviceState deviceState = new DeviceState(updateDeviceStatusCommand.getDeviceId(),
                updateDeviceStatusCommand.getStateType(),
                OffsetDateTime.now(ZoneOffset.UTC));
        return this.updateDeviceState.update(deviceState);
    }
}
