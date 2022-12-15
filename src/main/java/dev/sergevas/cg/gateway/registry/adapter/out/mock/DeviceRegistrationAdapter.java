package dev.sergevas.cg.gateway.registry.adapter.out.mock;

import dev.sergevas.cg.gateway.registry.application.port.out.LoadDeviceRegistration;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class DeviceRegistrationAdapter implements LoadDeviceRegistration {

    @Inject
    DeviceRegistrationDataStore deviceRegistrationDataStore;

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
}
