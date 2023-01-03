package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceState;
import dev.sergevas.cg.gateway.registry.domain.StateType;
import dev.sergevas.cg.gateway.shared.adapter.in.web.hal.HalBuilder;
import dev.sergevas.cg.gateway.shared.adapter.in.web.hal.HalHref;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDeviceCurrentStateTypeMapperTest {

    private UriInfo uriInfo;

    @BeforeEach
    void setup() {
        UriBuilder uriBuilder = mock(UriBuilder.class);
        when(uriBuilder.path(StatusApi.class)).thenReturn(uriBuilder);
        when(uriBuilder.path(anyString())).thenReturn(uriBuilder);
        when(uriBuilder.build()).thenReturn(URI.create("http://localhost:9080/gateway/registry/devices/0001/status"));
        uriInfo = mock(UriInfo.class);
        when(uriInfo.getBaseUriBuilder()).thenReturn(uriBuilder);
    }

    @Test
    void should_ReturnExpectedDeviceStateType_IfInputOk() {
        OffsetDateTime lastUpdated = OffsetDateTime.now(ZoneOffset.UTC);
        DeviceState deviceState = new DeviceState("0001", StateType.ACTIVE, lastUpdated);
        ToDeviceCurrentStateTypeMapper mapper = new ToDeviceCurrentStateTypeMapper();
        mapper.setHalBuilder(new HalBuilder());
        assertEquals(new DeviceCurrentStateType()
                .deviceId("0001")
                .deviceState(DeviceStateType.ACTIVE).links(Map.of("self",
                                new HalHref().href(URI.create("http://localhost:9080/gateway/registry/devices/0001/status"))))
                .lastUpdated(lastUpdated), mapper.map(deviceState, uriInfo));
    }
}
