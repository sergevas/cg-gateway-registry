package dev.sergevas.cg.gateway.registry.adapter.out.persistence.model;

import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class DeviceCurrentState extends BaseEntity {

    private String deviceId;
    private String deviceState;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceCurrentState that = (DeviceCurrentState) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(deviceState, that.deviceState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceId, deviceState);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceCurrentState.class.getSimpleName() + "[", "]")
                .add("id='" + super.getId() + "'")
                .add("deviceId='" + deviceId + "'")
                .add("deviceState='" + deviceState + "'")
                .toString();
    }
}
