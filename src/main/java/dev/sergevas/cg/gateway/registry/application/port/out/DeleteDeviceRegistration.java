package dev.sergevas.cg.gateway.registry.application.port.out;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

public interface DeleteDeviceRegistration {

    DeviceRegistration delete(String deviceId);
}
