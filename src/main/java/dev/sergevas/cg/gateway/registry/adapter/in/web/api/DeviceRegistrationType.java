package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.shared.adapter.in.web.HalEmbeddedType;
import jakarta.json.bind.annotation.JsonbProperty;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.*;

public class DeviceRegistrationType {

    @JsonbProperty("_links")
    Map<String, URI> links = new HashMap<>();
    private String deviceType;
    private String deviceId;
    private String deviceUri;
    private Integer statusUpdatePeriod;
    private OffsetDateTime created;
    private OffsetDateTime lastUpdated;
    private List<String> deviceTags = new ArrayList<String>();
    @JsonbProperty("_embedded")
    private HalEmbeddedType halEmbeddedType;

    public OffsetDateTime getCreated() {
        return created;
    }

    public DeviceRegistrationType created(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public DeviceRegistrationType lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public HalEmbeddedType getHalEmbeddedType() {
        return halEmbeddedType;
    }

    public DeviceRegistrationType halEmbeddedType(HalEmbeddedType halEmbeddedType) {
        this.halEmbeddedType = halEmbeddedType;
        return this;
    }

    public DeviceRegistrationType links(Map<String, URI> links) {
        this.links = links;
        return this;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    /**
     * Device type description
     **/
    public DeviceRegistrationType deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

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
        DeviceRegistrationType that = (DeviceRegistrationType) o;
        return Objects.equals(deviceType, that.deviceType)
                && Objects.equals(deviceId, that.deviceId)
                && Objects.equals(deviceUri, that.deviceUri)
                && Objects.equals(statusUpdatePeriod, that.statusUpdatePeriod)
                && Objects.equals(created, that.created)
                && Objects.equals(lastUpdated, that.lastUpdated)
                && Objects.equals(deviceTags, that.deviceTags)
                && Objects.equals(links, that.links)
                && Objects.equals(halEmbeddedType, that.halEmbeddedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, deviceId, deviceUri, statusUpdatePeriod, created, lastUpdated, deviceTags, links, halEmbeddedType);
    }
}
