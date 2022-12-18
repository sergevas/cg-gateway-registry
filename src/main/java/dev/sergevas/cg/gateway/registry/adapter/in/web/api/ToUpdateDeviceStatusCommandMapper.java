package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToUpdateDeviceStatusCommandMapper {

    public UpdateDeviceStatusCommand map(String deviceId, DeviceStateType stateType) {
        return new UpdateDeviceStatusCommand(deviceId,
                dev.sergevas.cg.gateway.registry.domain.DeviceStateType.valueOf(stateType.toString()));
    }
}
