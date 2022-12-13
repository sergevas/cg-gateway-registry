package dev.sergevas.cg.gateway.registry.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceRegistration {

    private String deviceId;
    private String deviceType;
    private String deviceUri;
    private Integer statusUpdatePeriod;
    private List<String> deviceTags;

    public DeviceRegistration(String deviceId, String deviceType, String deviceUri, Integer statusUpdatePeriod, List<String> deviceTags) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceUri = deviceUri;
        this.statusUpdatePeriod = statusUpdatePeriod;
        this.deviceTags = deviceTags;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceUri() {
        return deviceUri;
    }

    public void setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
    }

    public Integer getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public void setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
    }

    public List<String> getDeviceTags() {
        return deviceTags;
    }

    public void setDeviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceRegistration that = (DeviceRegistration) o;
        return Objects.equals(deviceId, that.deviceId)
                && Objects.equals(deviceType, that.deviceType)
                && Objects.equals(deviceUri, that.deviceUri)
                && Objects.equals(statusUpdatePeriod, that.statusUpdatePeriod)
                && Objects.equals(deviceTags, that.deviceTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceType, deviceUri, statusUpdatePeriod, deviceTags);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRegistration.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceType='" + deviceType + "'")
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .add("deviceTags=" + deviceTags)
                .toString();
    }
}
