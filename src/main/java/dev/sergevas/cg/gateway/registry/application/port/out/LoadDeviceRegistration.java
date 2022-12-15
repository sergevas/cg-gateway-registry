package dev.sergevas.cg.gateway.registry.application.port.out;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

import java.util.List;

public interface LoadDeviceRegistration {

    List<DeviceRegistration> load();
    DeviceRegistration load(String deviceId);
}
