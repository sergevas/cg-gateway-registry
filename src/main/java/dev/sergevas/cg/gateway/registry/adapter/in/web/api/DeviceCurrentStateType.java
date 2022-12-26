package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import java.time.OffsetDateTime;
import java.util.Objects;

public class DeviceCurrentStateType {

    private String deviceId;
    private DeviceStateType deviceState;
    private OffsetDateTime lastUpdated;

    public DeviceCurrentStateType deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceCurrentStateType deviceState(DeviceStateType deviceState) {
        this.deviceState = deviceState;
        return this;
    }

    public DeviceStateType getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceStateType deviceState) {
        this.deviceState = deviceState;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public DeviceCurrentStateType lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceCurrentStateType deviceCurrentStateType = (DeviceCurrentStateType) o;
        return Objects.equals(deviceId, deviceCurrentStateType.deviceId)
                && Objects.equals(deviceState, deviceCurrentStateType.deviceState)
                && Objects.equals(lastUpdated, deviceCurrentStateType.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceState, lastUpdated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceCurrentStateType {\n");

        sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
        sb.append("    deviceState: ").append(toIndentedString(deviceState)).append("\n");
        sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
