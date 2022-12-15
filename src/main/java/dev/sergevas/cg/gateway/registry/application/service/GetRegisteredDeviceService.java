package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetRegisteredDeviceQuery;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GetRegisteredDeviceService implements GetRegisteredDeviceQuery {

    private LoadDeviceRegistration loadDeviceRegistration;

    @Inject
    public GetRegisteredDeviceService(LoadDeviceRegistration loadDeviceRegistration) {
        this.loadDeviceRegistration = loadDeviceRegistration;
    }

    @Override
    public List<DeviceRegistration> getDevice() {
        return this.loadDeviceRegistration.load();
    }

    @Override
    public DeviceRegistration getDevice(final GetRegisteredDeviceCommand registeredDeviceCommand) {
        return Optional.ofNullable(this.loadDeviceRegistration.load(registeredDeviceCommand.getDeviceId()))
                .orElseThrow(() -> new DeviceNotFoundException(registeredDeviceCommand.getDeviceId()));
    }
}
