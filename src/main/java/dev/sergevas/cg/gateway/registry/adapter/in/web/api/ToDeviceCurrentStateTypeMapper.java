package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.shared.adapter.in.web.hal.HalBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;

import java.util.Map;

@ApplicationScoped
class ToDeviceCurrentStateTypeMapper {

    @Inject
    private HalBuilder halBuilder;

    public void setHalBuilder(HalBuilder halBuilder) {
        this.halBuilder = halBuilder;
    }

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
