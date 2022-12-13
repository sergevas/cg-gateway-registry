package dev.sergevas.cg.gateway.registry.application.port.out;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;

public interface UpdateDeviceState {

    DeviceState update(DeviceState deviceState);
}
