package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

public interface RegisterDeviceUseCase {

    DeviceRegistration register(RegisterDeviceCommand registerDeviceCommand);
}
