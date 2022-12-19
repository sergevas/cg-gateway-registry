package dev.sergevas.cg.gateway.registry.application.port.in;

public class DeviceAlreadyRegisteredException extends BaseDeviceException {

    public DeviceAlreadyRegisteredException(String deviceId) {
        super("Device already registered", deviceId);
    }
}
