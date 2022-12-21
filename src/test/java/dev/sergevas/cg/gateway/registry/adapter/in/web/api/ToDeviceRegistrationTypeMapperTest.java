package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDeviceRegistrationTypeMapperTest {

    UriInfo uriInfo;

    @BeforeEach
    void setup() {
        UriBuilder uriBuilder = mock(UriBuilder.class);
        when(uriBuilder.path(RegistrationApi.class)).thenReturn(uriBuilder);
        when(uriBuilder.path(anyString())).thenReturn(uriBuilder);
        when(uriBuilder.build()).thenReturn(URI.create("http://localhost:9080/gateway/registry/devices/0001"));
        uriInfo = mock(UriInfo.class);
        when(uriInfo.getBaseUriBuilder()).thenReturn(uriBuilder);
    }

    @Test
    void should_ReturnExpectedDeviceRegistrationType_IfInputOk() {
        DeviceRegistration deviceRegistration = new DeviceRegistration(
                "0001",
                "switch",
                "http://192.168.1.84/cg/actuator/switch/0001",
                10000,
                List.of("ESP8266", "SRD-05VDC-SL-C")
        );
        DeviceRegistrationType expected = new DeviceRegistrationType()
                .deviceId("0001")
                .deviceType("switch")
                .deviceUri("http://192.168.1.84/cg/actuator/switch/0001")
                .statusUpdatePeriod(10000)
                .deviceTags(List.of("ESP8266", "SRD-05VDC-SL-C"))
                .links(Map.of("self", URI.create("http://localhost:9080/gateway/registry/devices/0001")));
        ToDeviceRegistrationTypeMapper mapper = new ToDeviceRegistrationTypeMapper();
        assertEquals(expected, mapper.map(deviceRegistration, uriInfo));

    }
}
