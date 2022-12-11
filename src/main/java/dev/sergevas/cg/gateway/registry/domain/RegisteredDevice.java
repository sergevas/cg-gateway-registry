package dev.sergevas.cg.gateway.registry.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RegisteredDevice {

    private DeviceId deviceId;
    private String deviceType;
    private String deviceUri;
    private Integer statusUpdatePeriod;
    private List<String> deviceTags;

    public RegisteredDevice(DeviceId deviceId, String deviceType, String deviceUri, Integer statusUpdatePeriod, List<String> deviceTags) {
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

    public RegisteredDevice setDeviceId(DeviceId deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public RegisteredDevice setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public RegisteredDevice setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
        return this;
    }

    public RegisteredDevice setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
        return this;
    }

    public RegisteredDevice setDeviceTags(List<String> deviceTags) {
        this.deviceTags = deviceTags;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredDevice that = (RegisteredDevice) o;
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
        return new StringJoiner(", ", RegisteredDevice.class.getSimpleName() + "[", "]")
                .add("deviceId=" + deviceId)
                .add("deviceType='" + deviceType + "'")
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .add("deviceTags=" + deviceTags)
                .toString();
    }
}
