package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceStateType;
import dev.sergevas.cg.gateway.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.StringJoiner;

public class UpdateDeviceStatusCommand extends SelfValidating<UpdateDeviceStatusCommand> {

    private final String deviceId;
    @NotNull
    private final DeviceStateType deviceStateType;

    public UpdateDeviceStatusCommand(String deviceId, DeviceStateType deviceStateType) {
        this.deviceId = deviceId;
        this.deviceStateType = deviceStateType;
        super.validateSelf();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceStateType getDeviceStateType() {
        return deviceStateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateDeviceStatusCommand that = (UpdateDeviceStatusCommand) o;
        return Objects.equals(deviceId, that.deviceId) && deviceStateType == that.deviceStateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceStateType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateDeviceStatusCommand.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceStateType=" + deviceStateType)
                .toString();
    }
}
