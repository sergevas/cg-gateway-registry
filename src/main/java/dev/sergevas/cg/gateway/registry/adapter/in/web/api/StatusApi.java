package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.GetDeviceStatusQuery;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusCommand;
import dev.sergevas.cg.gateway.registry.application.port.in.UpdateDeviceStatusUseCase;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registry/devices/{deviceId}/status")
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class StatusApi {

    private final GetDeviceStatusQuery getDeviceCurrentStateQuery;
    private final UpdateDeviceStatusUseCase updateDeviceStatusUseCase;
    private final ToDeviceCurrentStateTypeMapper toDeviceCurrentStateMapper;
    private final ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper;

    public StatusApi(GetDeviceStatusQuery getDeviceCurrentStateQuery,
                     UpdateDeviceStatusUseCase updateDeviceStatusUseCase,
                     ToDeviceCurrentStateTypeMapper toDeviceCurrentStateMapper,
                     ToUpdateDeviceStatusCommandMapper toUpdateDeviceStatusCommandMapper) {
        this.getDeviceCurrentStateQuery = getDeviceCurrentStateQuery;
        this.updateDeviceStatusUseCase = updateDeviceStatusUseCase;
        this.toDeviceCurrentStateMapper = toDeviceCurrentStateMapper;
        this.toUpdateDeviceStatusCommandMapper = toUpdateDeviceStatusCommandMapper;
    }

    @GetMapping(produces = "application/hal+json")
    public ResponseEntity<DeviceCurrentStateType> getDeviceStatus(@PathVariable("deviceId") String deviceId) {
        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.getDeviceCurrentStateQuery.getDeviceStatus(new GetDeviceStatusCommand(deviceId)));
        return ResponseEntity.ok(currentStateType);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/hal+json")
    public ResponseEntity<DeviceCurrentStateType> updateDeviceStatus(@PathVariable("deviceId") String deviceId, DeviceStateType stateType) {
        UpdateDeviceStatusCommand updateDeviceStatusCommand = this.toUpdateDeviceStatusCommandMapper.map(deviceId, stateType);
        DeviceCurrentStateType currentStateType = this.toDeviceCurrentStateMapper
                .map(this.updateDeviceStatusUseCase.updateDeviceStatus(updateDeviceStatusCommand));
        return ResponseEntity.ok(currentStateType);
    }
}
