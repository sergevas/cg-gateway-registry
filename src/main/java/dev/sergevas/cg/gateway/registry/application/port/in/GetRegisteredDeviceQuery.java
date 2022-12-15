package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;

import java.util.List;

public interface GetRegisteredDeviceQuery {

    List<DeviceRegistration> getDevice();

    DeviceRegistration getDevice(GetRegisteredDeviceCommand registeredDeviceCommand);
}