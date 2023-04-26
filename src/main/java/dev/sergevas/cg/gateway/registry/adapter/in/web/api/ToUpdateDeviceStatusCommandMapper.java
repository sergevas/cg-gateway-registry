package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class ToUpdateDeviceStatusCommandMapper {

    public UpdateDeviceStatusCommand map(String deviceId, DeviceStateType stateType) {
        return new UpdateDeviceStatusCommand(deviceId,
                Optional.ofNullable(stateType)
                        .map(st -> StateType.valueOf(st.toString()))
                        .orElse(null));
    }
}
