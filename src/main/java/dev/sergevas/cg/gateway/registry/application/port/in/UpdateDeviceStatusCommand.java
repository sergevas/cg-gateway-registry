package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.StateType;
import dev.sergevas.cg.gateway.shared.application.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.StringJoiner;

public class UpdateDeviceStatusCommand extends SelfValidating<UpdateDeviceStatusCommand> {

    @NotBlank
    private final String deviceId;
    @NotNull
    private final StateType stateType;

    public UpdateDeviceStatusCommand(String deviceId, StateType stateType) {
        this.deviceId = deviceId;
        this.stateType = stateType;
        super.validateSelf();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public StateType getStateType() {
        return stateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateDeviceStatusCommand that = (UpdateDeviceStatusCommand) o;
        return Objects.equals(deviceId, that.deviceId) && stateType == that.stateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, stateType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateDeviceStatusCommand.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("stateType=" + stateType)
                .toString();
    }
}
