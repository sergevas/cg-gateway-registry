package dev.sergevas.cg.gateway.registry.application.port.in;

public class DeviceNotFoundException extends BaseDeviceException {

    public DeviceNotFoundException(String deviceId) {
        super("Device not found", deviceId);
    }
}
