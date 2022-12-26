package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.shared.SelfValidating;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RegisterDeviceCommand extends SelfValidating<RegisterDeviceCommand> {

    @Valid
    private final DeviceRegistration deviceRegistration;

    public RegisterDeviceCommand(
            String deviceId,
            String deviceType,
            String deviceUri,
            Integer statusUpdatePeriod,
            List<String> deviceTags) {
        this.deviceRegistration = new DeviceRegistration(
                deviceId,
                deviceType,
                deviceUri,
                statusUpdatePeriod,
                deviceTags);
        super.validateSelf();
    }

    public DeviceRegistration getDeviceRegistration() {
        return deviceRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDeviceCommand that = (RegisterDeviceCommand) o;
        return Objects.equals(deviceRegistration, that.deviceRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceRegistration);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterDeviceCommand.class.getSimpleName() + "[", "]")
                .add("deviceRegistration=" + deviceRegistration)
                .toString();
    }
}
