package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.RegisterDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.RegisterDeviceUseCase;
import dev.sergevas.cg.gateway.registry.application.port.out.SaveDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RegisterDeviceService implements RegisterDeviceUseCase {

    @Inject
    private SaveDeviceRegistration saveDeviceRegistration;

    @Override
    public DeviceRegistration register(RegisterDeviceCommand registerDeviceCommand) {
        return saveDeviceRegistration.save(registerDeviceCommand.getDeviceRegistration());
    }
}
