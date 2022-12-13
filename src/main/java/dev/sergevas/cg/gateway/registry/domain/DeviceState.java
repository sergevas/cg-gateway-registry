package dev.sergevas.cg.gateway.registry.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class DeviceState {

    public String deviceId;
    public DeviceStateType stateType;

    public DeviceState(String deviceId, DeviceStateType stateType) {
        this.deviceId = deviceId;
        this.stateType = stateType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public DeviceState setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public DeviceStateType getStateType() {
        return stateType;
    }

    public DeviceState setStateType(DeviceStateType stateType) {
        this.stateType = stateType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceState that = (DeviceState) o;
        return Objects.equals(deviceId, that.deviceId) && stateType == that.stateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, stateType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceState.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("stateType=" + stateType)
                .toString();
    }
}
