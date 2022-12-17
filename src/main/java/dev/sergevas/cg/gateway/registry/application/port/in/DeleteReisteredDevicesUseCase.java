package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

public interface DeleteReisteredDevicesUseCase {
    DeviceRegistration deleteRegisteredDevice(DeleteRegisteredDeviceCommand deleteRegisteredDeviceCommand);
}
