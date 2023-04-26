package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.shared.adapter.in.web.hal.HalBuilder;
import jakarta.ws.rs.core.UriInfo;

import java.util.Map;

class ToDeviceCurrentStateTypeMapper {

    public ToDeviceCurrentStateTypeMapper(HalBuilder halBuilder) {
        this.halBuilder = halBuilder;
    }

    private final HalBuilder halBuilder;

    DeviceCurrentStateType map(DeviceState deviceState, UriInfo uriInfo) {
        DeviceCurrentStateType deviceCurrentStateType = new DeviceCurrentStateType()
                .deviceState(DeviceStateType.fromValue(deviceState.getStateType().getType()))
                .deviceId(deviceState.getDeviceId())
                .lastUpdated(deviceState.getLastUpdated());
        halBuilder.appendSelf(deviceCurrentStateType.getLinks(), uriInfo.getBaseUriBuilder()
                .path(StatusApi.class)
                .buildFromMap(Map.of("deviceId", deviceCurrentStateType.getDeviceId())));
        return deviceCurrentStateType;
    }
}
