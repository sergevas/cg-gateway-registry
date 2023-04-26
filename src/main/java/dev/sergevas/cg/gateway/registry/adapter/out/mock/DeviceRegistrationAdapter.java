package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.out.DeleteDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.SaveDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceRegistrationAdapter implements LoadDeviceRegistration,
        SaveDeviceRegistration, DeleteDeviceRegistration {

    private final DeviceRegistrationDataStore deviceRegistrationDataStore;

    public DeviceRegistrationAdapter(DeviceRegistrationDataStore deviceRegistrationDataStore) {
        this.deviceRegistrationDataStore = deviceRegistrationDataStore;
    }

    @Override
    public List<DeviceRegistration> load() {
        List<DeviceRegistration> deviceRegistrations = new ArrayList<>();
        deviceRegistrations.addAll(this.deviceRegistrationDataStore.getDeviceRegistrationStore().values());
        return deviceRegistrations;
    }

    @Override
    public DeviceRegistration load(String deviceId) {
        return this.deviceRegistrationDataStore.getDeviceRegistrationStore().get(deviceId);
    }

    @Override
    public DeviceRegistration save(DeviceRegistration deviceRegistration) {
        String deviceId = deviceRegistration.getDeviceId();
        this.deviceRegistrationDataStore.getDeviceRegistrationStore().put(deviceId, deviceRegistration);
        return this.deviceRegistrationDataStore.getDeviceRegistrationStore().get(deviceId);
    }

    @Override
    public DeviceRegistration delete(String deviceId) {
        return this.deviceRegistrationDataStore.getDeviceRegistrationStore().remove(deviceId);
    }
}
