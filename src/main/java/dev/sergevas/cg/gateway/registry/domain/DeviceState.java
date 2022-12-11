package dev.sergevas.cg.gateway.registry.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class DeviceState {

    public enum StateType {
        ACTIVE("ACTIVE"),
        SLEEPING("SLEEPING"),
        STOPPED("STOPPED"),
        ERROR("ERROR");

        private String type;

        private StateType(String mode) {
            this.type = mode;
        }

        public String getType() {
            return type;
        }
    }

    public DeviceId deviceId;
    public StateType stateType;

    public DeviceState(DeviceId deviceId, StateType stateType) {
        this.deviceId = deviceId;
        this.stateType = stateType;
    }

    public DeviceId getDeviceId() {
        return deviceId;
    }

    public DeviceState setDeviceId(DeviceId deviceId) {
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
                .add("deviceId=" + deviceId)
                .add("stateType=" + stateType)
                .toString();
    }
}
