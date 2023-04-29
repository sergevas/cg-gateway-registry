package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDeviceRegistrationTypeMapperTest {

    @Test
    void should_ReturnExpectedDeviceRegistrationType_IfInputOk() {
        OffsetDateTime created = OffsetDateTime
                .of(LocalDateTime
                        .of(2022, Month.OCTOBER, 20, 1, 27, 0), ZoneOffset.UTC);

        OffsetDateTime lastUpdated = OffsetDateTime
                .of(LocalDateTime
                        .of(2022, Month.DECEMBER, 27, 1, 27, 0), ZoneOffset.UTC);

        DeviceRegistration deviceRegistration = new DeviceRegistration(
                "0001",
                "switch",
                "http://192.168.1.84/cg/actuator/switch/0001",
                10000,
                created,
                lastUpdated,
                List.of("ESP8266", "SRD-05VDC-SL-C")
        );
        DeviceRegistrationType expected = new DeviceRegistrationType()
                .deviceId("0001")
                .deviceType("switch")
                .deviceUri("http://192.168.1.84/cg/actuator/switch/0001")
                .statusUpdatePeriod(10000)
                .created(created)
                .lastUpdated(lastUpdated)
                .deviceTags(List.of("ESP8266", "SRD-05VDC-SL-C"));
        ToDeviceRegistrationTypeMapper mapper = new ToDeviceRegistrationTypeMapper(new ToDeviceCurrentStateTypeMapper());
        assertEquals(expected, mapper.map(deviceRegistration));
    }
}
