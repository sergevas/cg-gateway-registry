package dev.sergevas.cg.gateway.registry.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceRegistration {

    @NotBlank
    private String deviceId;
    @NotBlank
    private String deviceType;
    @NotBlank
    private String deviceUri;
    @NotNull
    @PositiveOrZero
    private Integer statusUpdatePeriod;
    private OffsetDateTime created;
    private OffsetDateTime lastUpdated;
    private List<String> deviceTags;

    private DeviceState deviceState;

    public DeviceRegistration(
            String deviceId,
            String deviceType,
            String deviceUri,
            Integer statusUpdatePeriod,
            OffsetDateTime created,
            OffsetDateTime lastUpdated,
            DeviceState deviceState,
            List<String> deviceTags) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceUri = deviceUri;
        this.statusUpdatePeriod = statusUpdatePeriod;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.deviceState = deviceState;
        this.deviceTags = deviceTags;
    }

    public DeviceRegistration(
            String deviceId,
            String deviceType,
            String deviceUri,
            Integer statusUpdatePeriod,
            OffsetDateTime created,
            OffsetDateTime lastUpdated,
            List<String> deviceTags) {
        this(deviceId, deviceType, deviceUri, statusUpdatePeriod, created, lastUpdated, null, deviceTags);
    }

    public DeviceRegistration(
            String deviceId,
            String deviceType,
            String deviceUri,
            Integer statusUpdatePeriod,
            List<String> deviceTags) {
        this(deviceId, deviceType, deviceUri, statusUpdatePeriod, null, null, null, deviceTags);
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

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public DeviceState getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
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
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(deviceType, that.deviceType)
                && Objects.equals(deviceUri, that.deviceUri) && Objects.equals(statusUpdatePeriod, that.statusUpdatePeriod)
                && Objects.equals(created, that.created) && Objects.equals(lastUpdated, that.lastUpdated)
                && Objects.equals(deviceTags, that.deviceTags) && Objects.equals(deviceState, that.deviceState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceType, deviceUri, statusUpdatePeriod, created, lastUpdated, deviceTags, deviceState);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRegistration.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceType='" + deviceType + "'")
                .add("deviceUri='" + deviceUri + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod + "'")
                .add("created=" + created + "'")
                .add("lastUpdated=" + lastUpdated + "'")
                .add("deviceState=" + deviceState)
                .add("deviceTags=" + deviceTags)
                .toString();
    }
}
