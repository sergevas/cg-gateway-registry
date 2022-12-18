package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class DeviceCurrentStateType {

    private @Valid String deviceId = null;
    private @Valid DeviceStateType deviceState = null;

    public DeviceCurrentStateType deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @JsonbProperty("deviceId")
    @Size(max = 4)
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

    @JsonbProperty("deviceState")
    public DeviceStateType getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceStateType deviceState) {
        this.deviceState = deviceState;
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
        return Objects.equals(deviceId, deviceCurrentStateType.deviceId) &&
                Objects.equals(deviceState, deviceCurrentStateType.deviceState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceState);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceCurrentStateType {\n");

        sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
        sb.append("    deviceState: ").append(toIndentedString(deviceState)).append("\n");
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
