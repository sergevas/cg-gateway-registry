package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import org.springframework.stereotype.Component;

@Component
class ToDeviceCurrentStateTypeMapper {

    DeviceCurrentStateType map(DeviceState deviceState) {
        DeviceCurrentStateType deviceCurrentStateType = new DeviceCurrentStateType()
                .deviceState(DeviceStateType.fromValue(deviceState.getStateType().getType()))
                .deviceId(deviceState.getDeviceId())
                .lastUpdated(deviceState.getLastUpdated());
        return deviceCurrentStateType;
    }
}
