package dev.sergevas.cg.gateway.registry.application.port.in;

public class DeviceNotFoundException extends RuntimeException {

    private String deviceId;

    public DeviceNotFoundException() {
    }

    public DeviceNotFoundException(String message) {
        super(message);
    }

    public DeviceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceNotFoundException(Throwable cause) {
        super(cause);
    }

    public DeviceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getDeviceId() {
        return deviceId;
    }
}
