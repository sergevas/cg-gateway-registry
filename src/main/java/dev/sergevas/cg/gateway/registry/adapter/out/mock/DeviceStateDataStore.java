package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class DeviceStateDataStore {

    private Map<String, DeviceState> deviceStateStore;

    @PostConstruct
    void init() {
        deviceStateStore = new ConcurrentHashMap<>();
        deviceStateStore.put("0001", new DeviceState("0001", StateType.ACTIVE));
        deviceStateStore.put("0002", new DeviceState("0002", StateType.ACTIVE));
        deviceStateStore.put("0003", new DeviceState("0003", StateType.STOPPED));
        deviceStateStore.put("0004", new DeviceState("0004", StateType.SLEEPING));
        deviceStateStore.put("0005", new DeviceState("0005", StateType.ERROR));
        deviceStateStore.put("0006", new DeviceState("0006", StateType.ACTIVE));
        deviceStateStore.put("0007", new DeviceState("0007", StateType.STOPPED));
        deviceStateStore.put("0008", new DeviceState("0008", StateType.SLEEPING));
        deviceStateStore.put("0009", new DeviceState("0009", StateType.ERROR));
        deviceStateStore.put("0010", new DeviceState("0010", StateType.ACTIVE));
    }

    public Map<String, DeviceState> getDeviceStateStore() {
        return deviceStateStore;
    }
}
