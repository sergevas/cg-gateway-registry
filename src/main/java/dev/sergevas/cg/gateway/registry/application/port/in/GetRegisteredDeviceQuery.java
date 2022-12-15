package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;

import java.util.List;

public interface GetRegisteredDeviceQuery {

    List<DeviceRegistration> getDevices();

    DeviceRegistration getDevices(GetRegisteredDeviceCommand registeredDeviceCommand);
}