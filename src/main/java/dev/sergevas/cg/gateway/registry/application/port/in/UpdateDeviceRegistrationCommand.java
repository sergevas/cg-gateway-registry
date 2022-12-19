package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.shared.SelfValidating;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.StringJoiner;

public class UpdateDeviceRegistrationCommand extends SelfValidating<UpdateDeviceRegistrationCommand> {

    private final String deviceId;
    @NotNull
    @Valid
    private final DeviceRegistration deviceRegistration;

    public UpdateDeviceRegistrationCommand(String deviceId, DeviceRegistration deviceRegistration) {
        this.deviceId = deviceId;
        this.deviceRegistration = deviceRegistration;
        super.validateSelf();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceRegistration getDeviceRegistration() {
        return deviceRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateDeviceRegistrationCommand that = (UpdateDeviceRegistrationCommand) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(deviceRegistration, that.deviceRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceRegistration);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateDeviceRegistrationCommand.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceRegistration=" + deviceRegistration)
                .toString();
    }
}
