package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import dev.sergevas.cg.gateway.registry.application.port.out.UpdateDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class UpdateDeviceStatusService implements UpdateDeviceStatusUseCase {

    private final UpdateDeviceState updateDeviceState;

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
