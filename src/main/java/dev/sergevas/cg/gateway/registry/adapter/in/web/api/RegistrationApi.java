package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.*;
import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registry/devices")
public class RegistrationApi {

    private final GetRegisteredDeviceQuery getRegisteredDeviceQuery;
    private final ToDeviceRegistrationTypeMapper toDeviceRegistrationTypeMapper;
    private final RegisterDeviceUseCase registerDeviceUseCase;
    private final UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase;
    private final DeleteReisteredDevicesUseCase deleteReisteredDevicesUseCase;

    public RegistrationApi(GetRegisteredDeviceQuery getRegisteredDeviceQuery,
                           ToDeviceRegistrationTypeMapper toDeviceRegistrationTypeMapper,
                           RegisterDeviceUseCase registerDeviceUseCase,
                           UpdateDeviceRegistrationUseCase updateDeviceRegistrationUseCase,
                           DeleteReisteredDevicesUseCase deleteReisteredDevicesUseCase) {
        this.getRegisteredDeviceQuery = getRegisteredDeviceQuery;
        this.toDeviceRegistrationTypeMapper = toDeviceRegistrationTypeMapper;
        this.registerDeviceUseCase = registerDeviceUseCase;
        this.updateDeviceRegistrationUseCase = updateDeviceRegistrationUseCase;
        this.deleteReisteredDevicesUseCase = deleteReisteredDevicesUseCase;
    }
//    UriInfo uriInfo;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeviceRegistrationType>> getRegisteredDevices() {
        List<DeviceRegistration> deviceRegistrations = getRegisteredDeviceQuery.getDevice();
        List<DeviceRegistrationType> deviceRegistrationTypes = deviceRegistrations
                .stream()
                .map(dr -> toDeviceRegistrationTypeMapper.map(dr, uriInfo))
                .toList();
        return ResponseEntity.ok(deviceRegistrationTypes);
    }

    @GetMapping(path = "/{deviceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceRegistrationType> getRegisteredDeviceInfo(@PathVariable("deviceId") String deviceId) {
        DeviceRegistrationType deviceRegistrationType = toDeviceRegistrationTypeMapper
                .map(getRegisteredDeviceQuery.getDevice(new GetRegisteredDeviceCommand(deviceId)), uriInfo);
        return ResponseEntity.ok(deviceRegistrationType);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceRegistrationType> registerDevice(@RequestBody DeviceRegistrationType deviceRegistrationType) {
        RegisterDeviceCommand registerDeviceCommand = new RegisterDeviceCommand(
                deviceRegistrationType.getDeviceId(),
                deviceRegistrationType.getDeviceType(),
                deviceRegistrationType.getDeviceUri(),
                deviceRegistrationType.getStatusUpdatePeriod(),
                deviceRegistrationType.getDeviceTags());
        DeviceRegistrationType registered = toDeviceRegistrationTypeMapper
                .map(registerDeviceUseCase.register(registerDeviceCommand), uriInfo);
        return ResponseEntity.ok(registered);
    }

    @PutMapping(path = "/{deviceId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceRegistrationType> updateRegisteredDeviceInfo(@PathVariable("deviceId") String deviceId,
                                                                             @RequestBody DeviceRegistrationType deviceRegistrationType) {
        UpdateDeviceRegistrationCommand updateDeviceRegistrationCommand = new UpdateDeviceRegistrationCommand(
                deviceId,
                deviceRegistrationType.getDeviceId(),
                deviceRegistrationType.getDeviceType(),
                deviceRegistrationType.getDeviceUri(),
                deviceRegistrationType.getStatusUpdatePeriod(),
                deviceRegistrationType.getDeviceTags());
        DeviceRegistrationType updated = toDeviceRegistrationTypeMapper
                .map(updateDeviceRegistrationUseCase.updateDeviceRegistration(updateDeviceRegistrationCommand), uriInfo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "{deviceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteRegisteredDevice(@PathVariable("deviceId") String deviceId) {
        deleteReisteredDevicesUseCase.deleteRegisteredDevice(new DeleteRegisteredDeviceCommand(deviceId));
        return ResponseEntity.ok().build();
    }
}
