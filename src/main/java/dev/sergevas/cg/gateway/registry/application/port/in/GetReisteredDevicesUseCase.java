package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.RegisteredDevice;

import java.util.List;

public interface GetReisteredDevicesUseCase {
    List<RegisteredDevice> getRegisteredDevices();

    RegisteredDevice getRegisteredDevice(GetRegisteredDeviceCommand getRegisteredDeviceComand);
}
