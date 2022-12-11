package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class DeviceCurrentStateMapper {

    DeviceCurrentStateType toDeviceCurrentStateType(DeviceState deviceState) {
        return new DeviceCurrentStateType()
                .deviceId(deviceState.deviceId.getId())
                .deviceState(DeviceStateType.fromValue(deviceState.getStateType().getType()));
    }
}
