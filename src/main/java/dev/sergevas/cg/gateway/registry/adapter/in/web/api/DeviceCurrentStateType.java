package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class DeviceCurrentStateType {

    @JsonProperty("_links")
    Map<String, Object> links = new HashMap<>();
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

    public Map<String, Object> getLinks() {
        return links;
    }

    public DeviceCurrentStateType links(Map<String, Object> links) {
        this.links = links;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceCurrentStateType that = (DeviceCurrentStateType) o;
        return Objects.equals(deviceId, that.deviceId) && deviceState == that.deviceState && Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceState, lastUpdated, links);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceCurrentStateType.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("deviceState=" + deviceState)
                .add("lastUpdated=" + lastUpdated)
                .add("links=" + links)
                .toString();
    }
}
