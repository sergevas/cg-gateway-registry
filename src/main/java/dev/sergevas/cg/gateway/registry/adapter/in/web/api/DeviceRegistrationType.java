package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import jakarta.json.bind.annotation.JsonbProperty;

import java.net.URI;
import java.util.*;

public class DeviceRegistrationType {

    private String deviceType = null;
    private String deviceId = null;
    private String deviceUri = null;
    private Integer statusUpdatePeriod = null;
    private List<String> deviceTags = new ArrayList<String>();
    private Map<String, URI> links = new HashMap<>();

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

    @JsonbProperty("_links")
    public Map<String, URI> getLinks() {
        return links;
    }

    public DeviceRegistrationType links(Map<String, URI> links) {
        this.links = links;
        return this;
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
                Objects.equals(statusUpdatePeriod, deviceRegistrationType.statusUpdatePeriod) &&
                Objects.equals(links, deviceRegistrationType.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceType, deviceId, deviceTags, deviceUri, statusUpdatePeriod, links);
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
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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