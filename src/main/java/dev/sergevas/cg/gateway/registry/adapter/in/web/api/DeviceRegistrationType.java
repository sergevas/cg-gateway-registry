package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeviceRegistrationType {

    private @Valid String deviceType = null;
    private @Valid String deviceId = null;
    private @Valid List<String> deviceTags = new ArrayList<String>();
    private @Valid String deviceUri = null;
    private @Valid Integer statusUpdatePeriod = null;

    /**
     * Device type description
     **/
    public DeviceRegistrationType deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    @JsonbProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Device unique identifier
     **/
    public DeviceRegistrationType deviceId(String deviceId) {
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

    /**
     * Device description tags
     **/
    public DeviceRegistrationType deviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
        return this;
    }

    @JsonbProperty("deviceTags")
    public List<String> getDeviceTags() {
        return deviceTags;
    }

    public void setDeviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
    }

    /**
     * Device base URI
     **/
    public DeviceRegistrationType deviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
        return this;
    }

    @JsonbProperty("deviceUri")
    public String getDeviceUri() {
        return deviceUri;
    }

    public void setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
    }

    /**
     * Device status maximum update time interval on the gateway in milliseconds
     * minimum: 0
     **/
    public DeviceRegistrationType statusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
        return this;
    }

    @JsonbProperty("statusUpdatePeriod")
    @Min(0)
    public Integer getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public void setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceRegistrationType deviceRegistrationType = (DeviceRegistrationType) o;
        return Objects.equals(deviceType, deviceRegistrationType.deviceType) &&
                Objects.equals(deviceId, deviceRegistrationType.deviceId) &&
                Objects.equals(deviceTags, deviceRegistrationType.deviceTags) &&
                Objects.equals(deviceUri, deviceRegistrationType.deviceUri) &&
                Objects.equals(statusUpdatePeriod, deviceRegistrationType.statusUpdatePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, deviceId, deviceTags, deviceUri, statusUpdatePeriod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceRegistrationType {\n");

        sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
        sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
        sb.append("    deviceTags: ").append(toIndentedString(deviceTags)).append("\n");
        sb.append("    deviceUri: ").append(toIndentedString(deviceUri)).append("\n");
        sb.append("    statusUpdatePeriod: ").append(toIndentedString(statusUpdatePeriod)).append("\n");
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
