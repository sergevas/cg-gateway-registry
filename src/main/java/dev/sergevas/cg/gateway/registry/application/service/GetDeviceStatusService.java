package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusQuery;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import org.springframework.stereotype.Component;

@Component
public class GetDeviceStatusService implements GetDeviceStatusQuery {

    private final LoadDeviceState loadDeviceState;

    public GetDeviceStatusService(LoadDeviceState loadDeviceState) {
        this.loadDeviceState = loadDeviceState;
    }

    @Override
    public DeviceState getDeviceStatus(GetDeviceStatusCommand deviceCurrentStatusCommand) {
        return this.loadDeviceState.load(deviceCurrentStatusCommand.getDeviceId());
    }
}
