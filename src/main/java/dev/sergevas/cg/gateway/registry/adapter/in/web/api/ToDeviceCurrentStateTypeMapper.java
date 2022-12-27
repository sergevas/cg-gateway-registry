package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToDeviceCurrentStateTypeMapper {

    DeviceCurrentStateType map(DeviceState deviceState) {
        return new DeviceCurrentStateType()
                .deviceState(DeviceStateType.fromValue(deviceState.getStateType().getType()))
                .deviceId(deviceState.getDeviceId())
                .lastUpdated(deviceState.getLastUpdated());
    }
}
