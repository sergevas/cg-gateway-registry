package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusQuery;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetDeviceStatusService implements GetDeviceStatusQuery {

    private LoadDeviceState loadDeviceState;

    @Inject
    public GetDeviceStatusService(LoadDeviceState loadDeviceState) {
        this.loadDeviceState = loadDeviceState;
    }

    @Override
    public DeviceState getDeviceStatus(GetDeviceStatusCommand deviceCurrentStatusCommand) {
        return this.loadDeviceState.load(deviceCurrentStatusCommand.getDeviceId());
    }
}
