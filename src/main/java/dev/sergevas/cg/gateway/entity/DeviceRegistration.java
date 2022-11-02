package dev.sergevas.cg.gateway.entity;

import javax.persistence.Entity;
import java.util.StringJoiner;

@Entity
public class DeviceRegistration extends  BaseEntity {

    private String deviceId;
    private String deviceType;
    private String deviceTags;
    private String deviceUrl;
    private Long statusUpdatePeriod;

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

    public String getDeviceTags() {
        return deviceTags;
    }

    public void setDeviceTags(String deviceTags) {
        this.deviceTags = deviceTags;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
    }

    public Long getStatusUpdatePeriod() {
        return statusUpdatePeriod;
    }

    public void setStatusUpdatePeriod(Long statusUpdatePeriod) {
        this.statusUpdatePeriod = statusUpdatePeriod;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceRegistration.class.getSimpleName() + "[", "]")
                .add("id=" + super.getId() + "'")
                .add("deviceId='" + deviceId + "'")
                .add("deviceType='" + deviceType + "'")
                .add("deviceTags='" + deviceTags + "'")
                .add("deviceUrl='" + deviceUrl + "'")
                .add("statusUpdatePeriod=" + statusUpdatePeriod)
                .toString();
    }
}
