package dev.sergevas.cg.gateway.registry.domain;

import java.util.List;
import java.util.Objects;

public class RegisteredDevice {

    private String deviceId;
    private String deviceType;
    private String deviceUri;
    private Integer statusUpdatePeriod;
    private List<String> deviceTags;

    public RegisteredDevice(String deviceId, String deviceType, String deviceUri, Integer statusUpdatePeriod, List<String> deviceTags) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceUri = deviceUri;
        this.statusUpdatePeriod = statusUpdatePeriod;
        this.deviceTags = deviceTags;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public RegisteredDevice setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public RegisteredDevice setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceUri() {
        return deviceUri;
    }

    public RegisteredDevice setDeviceUri(String deviceUri) {
        this.deviceUri = deviceUri;
        return this;
    }

    public Integer getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public RegisteredDevice setStatusUpdatePeriod(Integer statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
        return this;
    }

    public List<String> getDeviceTags() {
        return deviceTags;
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
}
