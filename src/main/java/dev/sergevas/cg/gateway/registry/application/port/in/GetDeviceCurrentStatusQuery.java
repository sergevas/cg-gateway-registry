package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;

public interface GetDeviceCurrentStatusQuery {

    DeviceState getDeviceCurrentStatus(DeviceCurrentStatusCommand deviceCurrentStatusCommand);
}
