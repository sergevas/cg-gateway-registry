package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceState;
import dev.sergevas.cg.gateway.registry.application.port.out.UpdateDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceStateType;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DeviceStateAdapter implements LoadDeviceState, UpdateDeviceState {

    private Map<String, DeviceState> deviceStates;

    @PostConstruct
    public void init() {
        deviceStates = new HashMap<>();
        deviceStates.put("0001", new DeviceState("0001", DeviceStateType.ACTIVE));
        deviceStates.put("0002", new DeviceState("0002", DeviceStateType.ACTIVE));
        deviceStates.put("0003", new DeviceState("0003", DeviceStateType.STOPPED));
        deviceStates.put("0004", new DeviceState("0004", DeviceStateType.SLEEPING));
        deviceStates.put("0005", new DeviceState("0005", DeviceStateType.ERROR));
        deviceStates.put("0006", new DeviceState("0006", DeviceStateType.ACTIVE));
        deviceStates.put("0007", new DeviceState("0007", DeviceStateType.STOPPED));
        deviceStates.put("0008", new DeviceState("0008", DeviceStateType.SLEEPING));
        deviceStates.put("0009", new DeviceState("0009", DeviceStateType.ERROR));
        deviceStates.put("0010", new DeviceState("0010", DeviceStateType.ACTIVE));
    }

    @Override
    public DeviceState load(String deviceId) {
        return this.deviceStates.get(deviceId);
    }

    @Override
    public DeviceState update(DeviceState deviceState) {
        String deviceId = deviceState.getDeviceId();
        this.deviceStates.put(deviceId, deviceState);
        return this.deviceStates.get(deviceId);
    }
}
