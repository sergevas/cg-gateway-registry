package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class DeviceStateDataStore {

    private Map<String, DeviceState> deviceStateStore;

    @PostConstruct
    void init() {
        deviceStateStore = new ConcurrentHashMap<>();
        deviceStateStore.put("0001", new DeviceState("0001", StateType.ACTIVE, OffsetDateTime.now(ZoneOffset.UTC)));
        deviceStateStore.put("0002", new DeviceState("0002", StateType.ACTIVE, OffsetDateTime.now(ZoneOffset.UTC).minusHours(2L)));
        deviceStateStore.put("0003", new DeviceState("0003", StateType.STOPPED, OffsetDateTime.now(ZoneOffset.UTC).minusYears(1L)));
        deviceStateStore.put("0004", new DeviceState("0004", StateType.SLEEPING, OffsetDateTime.now(ZoneOffset.UTC)));
        deviceStateStore.put("0005", new DeviceState("0005", StateType.ERROR, OffsetDateTime.now(ZoneOffset.UTC).minusDays(11L)));
        deviceStateStore.put("0006", new DeviceState("0006", StateType.ACTIVE, OffsetDateTime.now(ZoneOffset.UTC).minusMinutes(20L)));
        deviceStateStore.put("0007", new DeviceState("0007", StateType.STOPPED, OffsetDateTime.now(ZoneOffset.UTC).minusHours(14L)));
        deviceStateStore.put("0008", new DeviceState("0008", StateType.SLEEPING, OffsetDateTime.now(ZoneOffset.UTC)));
        deviceStateStore.put("0009", new DeviceState("0009", StateType.ERROR, OffsetDateTime.now(ZoneOffset.UTC).minusDays(2L)));
        deviceStateStore.put("0010", new DeviceState("0010", StateType.ACTIVE, OffsetDateTime.now(ZoneOffset.UTC).minusDays(8L)));
    }

    public Map<String, DeviceState> getDeviceStateStore() {
        return deviceStateStore;
    }
}
