package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ToDeviceRegistrationTypeMapper {

    DeviceRegistrationType map(DeviceRegistration deviceRegistration) {
        DeviceRegistrationType deviceRegistrationType = new DeviceRegistrationType()
                .deviceId(deviceRegistration.getDeviceId())
                .deviceType(deviceRegistration.getDeviceType())
                .deviceUri(deviceRegistration.getDeviceUri())
                .statusUpdatePeriod(deviceRegistration.getStatusUpdatePeriod());
        deviceRegistrationType.getDeviceTags().addAll(deviceRegistration.getDeviceTags());
        return deviceRegistrationType;
    }
}
