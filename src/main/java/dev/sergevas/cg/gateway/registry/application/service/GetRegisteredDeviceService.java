package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceQuery;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GetRegisteredDeviceService implements GetRegisteredDeviceQuery {

    private LoadDeviceRegistration loadDeviceRegistration;
    private LoadDeviceState loadDeviceState;

    @Inject
    public GetRegisteredDeviceService(LoadDeviceRegistration loadDeviceRegistration, LoadDeviceState loadDeviceState) {
        this.loadDeviceRegistration = loadDeviceRegistration;
        this.loadDeviceState = loadDeviceState;
    }

    @Override
    public List<DeviceRegistration> getDevice() {
        List<DeviceRegistration> deviceRegistrations = this.loadDeviceRegistration.load();
        return deviceRegistrations.stream().map(this::enrichWithStatusInfo).toList();
    }

    @Override
    public DeviceRegistration getDevice(final GetRegisteredDeviceCommand registeredDeviceCommand) {
        return Optional.ofNullable(this.loadDeviceRegistration.load(registeredDeviceCommand.getDeviceId()))
                .map(this::enrichWithStatusInfo)
                .orElseThrow(() -> new DeviceNotFoundException(registeredDeviceCommand.getDeviceId()));
    }

    private DeviceRegistration enrichWithStatusInfo(DeviceRegistration deviceRegistration) {
        String deviceId = deviceRegistration.getDeviceId();
        DeviceState deviceState = this.loadDeviceState.load(deviceId);
        deviceRegistration.setDeviceState(deviceState);
        return deviceRegistration;
    }
}
