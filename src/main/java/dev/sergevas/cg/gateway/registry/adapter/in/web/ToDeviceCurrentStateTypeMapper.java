package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToDeviceCurrentStateTypeMapper {

    DeviceCurrentStateType map(DeviceState deviceState) {
        return new DeviceCurrentStateType()
                .deviceId(deviceState.getDeviceId())
                .deviceState(DeviceStateType.fromValue(deviceState.getStateType().getType()));
    }
}
