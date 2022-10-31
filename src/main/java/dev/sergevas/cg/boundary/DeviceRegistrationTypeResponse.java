package dev.sergevas.cg.boundary;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceRegistrationTypeResponse {

    private String deviceType;
    private String deviceId;
    private List<String> deviceTags;
    private String deviceUri;
    private Long statusUpdatePeriod;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<String> getDeviceTags() {
        return deviceTags;
    }

    public void setDeviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
    }

    public String getDeviceUri() {
        return deviceUri;
    }

    public void setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
    }

    public Long getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public void setStatusUpdatePeriod(Long statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
    }

    public DeviceRegistrationTypeResponse deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DeviceRegistrationTypeResponse deviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public DeviceRegistrationTypeResponse deviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
        return this;
    }

    public DeviceRegistrationTypeResponse deviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
        return this;
    }

    public DeviceRegistrationTypeResponse statusUpdatePeriod(Long statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceRegistrationTypeResponse that = (DeviceRegistrationTypeResponse) o;
        return Objects.equals(deviceType, that.deviceType)
                && Objects.equals(deviceId, that.deviceId)
                && Objects.equals(deviceTags, that.deviceTags)
                && Objects.equals(deviceUri, that.deviceUri)
                && Objects.equals(statusUpdatePeriod, that.statusUpdatePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, deviceId, deviceTags, deviceUri, statusUpdatePeriod);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRegistrationTypeResponse.class.getSimpleName() + "[", "]")
                .add("deviceType='" + deviceType + "'")
                .add("deviceId='" + deviceId + "'")
                .add("deviceTags=" + deviceTags)
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .toString();
    }
}
