package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceAlreadyRegisteredException;
import dev.sergevas.cg.gateway.registry.application.port.in.RegisterDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.RegisterDeviceUseCase;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.SaveDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@ApplicationScoped
public class RegisterDeviceService implements RegisterDeviceUseCase {

    @Inject
    private LoadDeviceRegistration loadDeviceRegistration;
    @Inject
    private SaveDeviceRegistration saveDeviceRegistration;

    @Override
    public DeviceRegistration register(RegisterDeviceCommand registerDeviceCommand) {
        if (loadDeviceRegistration.load(registerDeviceCommand.getDeviceRegistration().getDeviceId()) != null) {
            throw new DeviceAlreadyRegisteredException(registerDeviceCommand.getDeviceRegistration().getDeviceId());
        }
        DeviceRegistration deviceRegistration = registerDeviceCommand.getDeviceRegistration();
        deviceRegistration.setCreated(OffsetDateTime.now(ZoneOffset.UTC));
        return saveDeviceRegistration.save(registerDeviceCommand.getDeviceRegistration());
    }
}
