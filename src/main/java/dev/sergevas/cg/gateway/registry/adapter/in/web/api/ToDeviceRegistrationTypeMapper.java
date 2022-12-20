package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.UriInfo;

@ApplicationScoped
class ToDeviceRegistrationTypeMapper {

    DeviceRegistrationType map(DeviceRegistration deviceRegistration, UriInfo uriInfo) {
        DeviceRegistrationType deviceRegistrationType = new DeviceRegistrationType()
                .deviceId(deviceRegistration.getDeviceId())
                .deviceType(deviceRegistration.getDeviceType())
                .deviceUri(deviceRegistration.getDeviceUri())
                .statusUpdatePeriod(deviceRegistration.getStatusUpdatePeriod());
        deviceRegistrationType.getDeviceTags().addAll(deviceRegistration.getDeviceTags());
        deviceRegistrationType.getLinks()
                .put("self", uriInfo.getBaseUriBuilder()
                        .path(RegistrationApi.class)
                        .path(deviceRegistration.getDeviceId())
                        .build());
        return deviceRegistrationType;
    }
}
