package dev.sergevas.cg.gateway.registry.application.port.in;

public class BaseDeviceException extends RuntimeException {

    private String deviceId;

    public BaseDeviceException(String message, String deviceId) {
        super(message + ", deviceId=[" + deviceId + "]");
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
