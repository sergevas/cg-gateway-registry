package dev.sergevas.cg.gateway.registry.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceState {

    @NotBlank
    private String deviceId;
    @NotNull
    private StateType stateType;
    private OffsetDateTime lastUpdated;

    public DeviceState(String deviceId, StateType stateType, OffsetDateTime lastUpdated) {
        this.deviceId = deviceId;
        this.stateType = stateType;
        this.lastUpdated = lastUpdated;
    }

    public DeviceState(String deviceId, StateType stateType) {
        this(deviceId, stateType, null);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceState setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public StateType getStateType() {
        return stateType;
    }

    public DeviceState setStateType(StateType stateType) {
        this.stateType = stateType;
        return this;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceState that = (DeviceState) o;
        return Objects.equals(deviceId, that.deviceId)
                && Objects.equals(lastUpdated, that.lastUpdated)
                && stateType == that.stateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, lastUpdated, stateType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceState.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("stateType=" + stateType)
                .add("lastUpdated='" + stateType + "'")
                .toString();
    }
}
