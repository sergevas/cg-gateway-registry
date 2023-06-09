package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.out.DeleteDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.application.port.out.SaveDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DeviceRegistrationAdapter implements LoadDeviceRegistration,
        SaveDeviceRegistration, DeleteDeviceRegistration {

    @Inject
    DeviceRegistrationDataStore deviceRegistrationDataStore;

    @Override
    public List<DeviceRegistration> load() {
        return new ArrayList<>(this.deviceRegistrationDataStore.getDeviceRegistrationStore().values());
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
