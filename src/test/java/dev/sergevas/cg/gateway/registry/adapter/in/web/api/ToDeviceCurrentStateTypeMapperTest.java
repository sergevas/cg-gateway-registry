package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDeviceCurrentStateTypeMapperTest {

    @Test
    void should_ReturnExpectedDeviceStateType_IfInputOk() {
        OffsetDateTime lastUpdated = OffsetDateTime.now(ZoneOffset.UTC);
        DeviceState deviceState = new DeviceState("0001", StateType.ACTIVE, lastUpdated);
        ToDeviceCurrentStateTypeMapper mapper = new ToDeviceCurrentStateTypeMapper();
        assertEquals(new DeviceCurrentStateType()
                .deviceId("0001")
                .deviceState(DeviceStateType.ACTIVE)
                .lastUpdated(lastUpdated), mapper.map(deviceState));
    }
}
