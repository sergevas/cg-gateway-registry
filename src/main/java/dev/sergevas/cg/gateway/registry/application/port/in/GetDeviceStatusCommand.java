package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.StringJoiner;

public class GetDeviceStatusCommand extends SelfValidating<GetDeviceStatusCommand> {

    @NotNull
    @Size(max = 4)
    private final String deviceId;

    public GetDeviceStatusCommand(String deviceId) {
        this.deviceId = deviceId;
        super.validateSelf();
    }

    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetDeviceStatusCommand that = (GetDeviceStatusCommand) o;
        return Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GetDeviceStatusCommand.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .toString();
    }
}
