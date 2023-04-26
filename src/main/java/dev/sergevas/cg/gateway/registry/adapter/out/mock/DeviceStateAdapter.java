package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceState;
import dev.sergevas.cg.gateway.registry.application.port.out.UpdateDeviceState;
import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import org.springframework.stereotype.Component;

@Component
public class DeviceStateAdapter implements LoadDeviceState, UpdateDeviceState {


    private final DeviceStateDataStore mockDeviceStateDataStore;

    public DeviceStateAdapter(DeviceStateDataStore mockDeviceStateDataStore) {
        this.mockDeviceStateDataStore = mockDeviceStateDataStore;
    }

    @Override
    public DeviceState load(String deviceId) {
        return this.mockDeviceStateDataStore.getDeviceStateStore().get(deviceId);
    }

    @Override
    public DeviceState update(DeviceState deviceState) {
        String deviceId = deviceState.getDeviceId();
        this.mockDeviceStateDataStore.getDeviceStateStore().put(deviceId, deviceState);
        return this.mockDeviceStateDataStore.getDeviceStateStore().get(deviceId);
    }
}
