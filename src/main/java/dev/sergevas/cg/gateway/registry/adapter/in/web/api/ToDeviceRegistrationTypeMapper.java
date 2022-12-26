package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.shared.adapter.in.web.HalBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;

@ApplicationScoped
class ToDeviceRegistrationTypeMapper {

    @Inject
    private HalBuilder halBuilder;

    public void setHalBuilder(HalBuilder halBuilder) {
        this.halBuilder = halBuilder;
    }

    DeviceRegistrationType map(DeviceRegistration deviceRegistration, UriInfo uriInfo) {
        DeviceRegistrationType deviceRegistrationType = new DeviceRegistrationType()
                .deviceId(deviceRegistration.getDeviceId())
                .deviceType(deviceRegistration.getDeviceType())
                .deviceUri(deviceRegistration.getDeviceUri())
                .statusUpdatePeriod(deviceRegistration.getStatusUpdatePeriod())
                .created(deviceRegistration.getCreated())
                .lastUpdated(deviceRegistration.getLastUpdated());
        deviceRegistrationType.getDeviceTags().addAll(deviceRegistration.getDeviceTags());

        halBuilder.appendSelf(deviceRegistrationType.getLinks(), uriInfo.getBaseUriBuilder()
                .path(RegistrationApi.class)
                .path(deviceRegistration.getDeviceId())
                .build());
        return deviceRegistrationType;
    }
}
