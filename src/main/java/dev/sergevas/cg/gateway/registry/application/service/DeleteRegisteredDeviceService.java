package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeleteRegisteredDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.DeleteReisteredDevicesUseCase;
import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import dev.sergevas.cg.gateway.registry.application.port.out.DeleteDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class DeleteRegisteredDeviceService implements DeleteReisteredDevicesUseCase {

    private DeleteDeviceRegistration deleteDeviceRegistration;

    @Inject
    public DeleteRegisteredDeviceService(DeleteDeviceRegistration deleteDeviceRegistration) {
        this.deleteDeviceRegistration = deleteDeviceRegistration;
    }

    @Override
    public DeviceRegistration deleteRegisteredDevice(final DeleteRegisteredDeviceCommand deleteRegisteredDeviceCommand) {
        return Optional.ofNullable(this.deleteDeviceRegistration.delete(deleteRegisteredDeviceCommand.getDeviceId()))
                .orElseThrow(() -> new DeviceNotFoundException(deleteRegisteredDeviceCommand.getDeviceId()));
    }
}
