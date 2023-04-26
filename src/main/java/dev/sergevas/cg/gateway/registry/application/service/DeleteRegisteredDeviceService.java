package dev.sergevas.cg.gateway.registry.application.service;

import dev.sergevas.cg.gateway.registry.application.port.in.DeleteRegisteredDeviceCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.DeleteReisteredDevicesUseCase;
import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import dev.sergevas.cg.gateway.registry.application.port.out.DeleteDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteRegisteredDeviceService implements DeleteReisteredDevicesUseCase {

    private final DeleteDeviceRegistration deleteDeviceRegistration;

    public DeleteRegisteredDeviceService(DeleteDeviceRegistration deleteDeviceRegistration) {
        this.deleteDeviceRegistration = deleteDeviceRegistration;
    }

    @Override
    public DeviceRegistration deleteRegisteredDevice(final DeleteRegisteredDeviceCommand deleteRegisteredDeviceCommand) {
        return Optional.ofNullable(this.deleteDeviceRegistration.delete(deleteRegisteredDeviceCommand.getDeviceId()))
                .orElseThrow(() -> new DeviceNotFoundException(deleteRegisteredDeviceCommand.getDeviceId()));
    }
}
