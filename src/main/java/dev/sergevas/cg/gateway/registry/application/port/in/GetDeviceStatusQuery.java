package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;

public interface GetDeviceStatusQuery {

    DeviceState getDeviceStatus(GetDeviceStatusCommand deviceCurrentStatusCommand);
}
