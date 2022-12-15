package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceStateType;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DeviceStateDataStore {

    private Map<String, DeviceState> deviceStateStore;

    @PostConstruct
    void init() {
        deviceStateStore = new HashMap<>();
        deviceStateStore.put("0001", new DeviceState("0001", DeviceStateType.ACTIVE));
        deviceStateStore.put("0002", new DeviceState("0002", DeviceStateType.ACTIVE));
        deviceStateStore.put("0003", new DeviceState("0003", DeviceStateType.STOPPED));
        deviceStateStore.put("0004", new DeviceState("0004", DeviceStateType.SLEEPING));
        deviceStateStore.put("0005", new DeviceState("0005", DeviceStateType.ERROR));
        deviceStateStore.put("0006", new DeviceState("0006", DeviceStateType.ACTIVE));
        deviceStateStore.put("0007", new DeviceState("0007", DeviceStateType.STOPPED));
        deviceStateStore.put("0008", new DeviceState("0008", DeviceStateType.SLEEPING));
        deviceStateStore.put("0009", new DeviceState("0009", DeviceStateType.ERROR));
        deviceStateStore.put("0010", new DeviceState("0010", DeviceStateType.ACTIVE));
    }

    public Map<String, DeviceState> getDeviceStateStore() {
        return deviceStateStore;
    }
}
