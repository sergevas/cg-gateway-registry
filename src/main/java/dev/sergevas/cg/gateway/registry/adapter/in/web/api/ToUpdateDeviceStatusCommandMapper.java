package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToUpdateDeviceStatusCommandMapper {

    public UpdateDeviceStatusCommand map(String deviceId, DeviceStateType stateType) {
        return new UpdateDeviceStatusCommand(deviceId,
                StateType.valueOf(stateType.toString()));
    }
}
