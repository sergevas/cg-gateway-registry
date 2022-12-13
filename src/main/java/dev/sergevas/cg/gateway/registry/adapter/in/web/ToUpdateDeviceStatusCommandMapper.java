package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.domain.DeviceStateType;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToUpdateDeviceStatusCommandMapper {

    public UpdateDeviceStatusCommand map(String deviceId, DeviceCurrentStateType currentState) {
        return new UpdateDeviceStatusCommand(deviceId, DeviceStateType.valueOf(currentState.getDeviceState().toString()));
    }
}
