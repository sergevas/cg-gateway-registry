package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;

public interface UpdateDeviceRegistrationUseCase {

    DeviceRegistration updateDeviceRegistration(UpdateDeviceRegistrationCommand UpdateDeviceRegistrationCommand);
}
