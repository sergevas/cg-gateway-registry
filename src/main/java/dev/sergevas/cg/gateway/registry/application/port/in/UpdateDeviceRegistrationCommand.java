package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import dev.sergevas.cg.gateway.shared.application.SelfValidating;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class UpdateDeviceRegistrationCommand extends SelfValidating<UpdateDeviceRegistrationCommand> {

    @NotBlank
    private final String deviceId;
    @Valid
    private final DeviceRegistration deviceRegistration;

    public UpdateDeviceRegistrationCommand(
            String deviceId,
            String deviceIdNew,
            String deviceType,
            String deviceUri,
            Integer statusUpdatePeriod,
            List<String> deviceTags) {
        this.deviceRegistration = new DeviceRegistration(
                deviceIdNew,
                deviceType,
                deviceUri,
                statusUpdatePeriod,
                deviceTags);
        this.deviceId = deviceId;
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
