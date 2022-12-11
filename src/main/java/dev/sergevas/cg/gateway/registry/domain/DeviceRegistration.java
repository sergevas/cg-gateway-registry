package dev.sergevas.cg.gateway.registry.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceRegistration {

    private DeviceId deviceId;
    private String deviceType;
    private String deviceUri;
    private Integer statusUpdatePeriod;
    private List<String> deviceTags;

    public DeviceRegistration(DeviceId deviceId, String deviceType, String deviceUri, Integer statusUpdatePeriod, List<String> deviceTags) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceUri = deviceUri;
        this.statusUpdatePeriod = statusUpdatePeriod;
        this.deviceTags = deviceTags;
    }

    public DeviceId deviceId() {
        return deviceId;
    }

    public String deviceType() {
        return deviceType;
    }

    public String deviceUri() {
        return deviceUri;
    }

    public Integer statusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public List<String> deviceTags() {
        return deviceTags;
    }

    public DeviceRegistration setDeviceId(DeviceId deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public DeviceRegistration setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DeviceRegistration setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
        return this;
    }

    public DeviceRegistration setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
        return this;
    }

    public DeviceRegistration setDeviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
        return this;
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
                .add("deviceId=" + deviceId)
                .add("deviceType='" + deviceType + "'")
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .add("deviceTags=" + deviceTags)
                .toString();
    }
}
