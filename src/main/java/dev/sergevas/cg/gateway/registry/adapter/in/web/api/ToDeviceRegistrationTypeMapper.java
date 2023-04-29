package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import org.springframework.stereotype.Component;

@Component
class ToDeviceRegistrationTypeMapper {
    private final ToDeviceCurrentStateTypeMapper toDeviceCurrentStateTypeMapper;

    public ToDeviceRegistrationTypeMapper(ToDeviceCurrentStateTypeMapper toDeviceCurrentStateTypeMapper) {
        this.toDeviceCurrentStateTypeMapper = toDeviceCurrentStateTypeMapper;
    }

    DeviceRegistrationType map(DeviceRegistration deviceRegistration) {
        DeviceRegistrationType deviceRegistrationType = new DeviceRegistrationType()
                .deviceId(deviceRegistration.getDeviceId())
                .deviceType(deviceRegistration.getDeviceType())
                .deviceUri(deviceRegistration.getDeviceUri())
                .statusUpdatePeriod(deviceRegistration.getStatusUpdatePeriod())
                .created(deviceRegistration.getCreated())
                .lastUpdated(deviceRegistration.getLastUpdated());
        deviceRegistrationType.getDeviceTags().addAll(deviceRegistration.getDeviceTags());
        return deviceRegistrationType;
    }
}

/*
 * "_embedded": {
 *     "status": {
 *         "_links": {
 *             "self": {
 *             "href": "http://localhost:9080/gateway/registry/devices/{deviceId}/status"
 *             }
 *         }
 *     }
 * }
 * */
