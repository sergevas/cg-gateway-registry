package dev.sergevas.cg.gateway.registry.adapter.in.web;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToDeviceCurrentStateTypeMapper {

    DeviceStateType map(DeviceState deviceState) {
        return DeviceStateType.fromValue(deviceState.getStateType().getType());
    }
}
