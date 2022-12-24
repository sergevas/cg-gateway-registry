package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.shared.adapter.in.web.HalType;
import jakarta.json.bind.annotation.JsonbProperty;

import java.net.URI;
import java.util.*;

public class DeviceRegistrationType extends HalType {

    private String deviceType = null;
    private String deviceId = null;
    private String deviceUri = null;
    private Integer statusUpdatePeriod = null;
    private List<String> deviceTags = new ArrayList<String>();

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
    public Integer getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public void setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceRegistrationType that = (DeviceRegistrationType) o;
        return Objects.equals(deviceType, that.deviceType)
                && Objects.equals(deviceId, that.deviceId)
                && Objects.equals(deviceUri, that.deviceUri)
                && Objects.equals(statusUpdatePeriod, that.statusUpdatePeriod)
                && Objects.equals(deviceTags, that.deviceTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceType, deviceId, deviceUri, statusUpdatePeriod, deviceTags);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRegistrationType.class.getSimpleName() + "[", "]")
                .add("deviceType='" + deviceType + "'")
                .add("deviceId='" + deviceId + "'")
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .add("deviceTags=" + deviceTags)
                .toString();
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
