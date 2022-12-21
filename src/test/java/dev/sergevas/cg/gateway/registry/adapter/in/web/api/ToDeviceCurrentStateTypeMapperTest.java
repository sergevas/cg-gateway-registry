package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDeviceCurrentStateTypeMapperTest {

    @Test
    void should_ReturnExpectedDeviceStateType_IfInputOk() {
        DeviceState deviceState = new DeviceState("0001", StateType.ACTIVE);
        ToDeviceCurrentStateTypeMapper mapper = new ToDeviceCurrentStateTypeMapper();
        assertEquals(DeviceStateType.ACTIVE, mapper.map(deviceState));
    }
}
