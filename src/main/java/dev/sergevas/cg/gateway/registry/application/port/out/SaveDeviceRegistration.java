package dev.sergevas.cg.gateway.registry.application.port.out;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

public interface SaveDeviceRegistration {

    DeviceRegistration save(DeviceRegistration deviceRegistration);
}
