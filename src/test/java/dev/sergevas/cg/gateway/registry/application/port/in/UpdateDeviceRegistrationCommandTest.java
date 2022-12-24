package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDeviceRegistrationCommandTest {

    @Test
    void should_ReturnExpectedDeviceId_IfInputOk() {
        UpdateDeviceRegistrationCommand command = new UpdateDeviceRegistrationCommand(
                "0001",
                "0002",
                "switch",
                "http://localhost:9080/gateway/registry/devices/0001",
                10000,
                List.of("ESP8266", "SRD-05VDC-SL-C"));
        DeviceRegistration expected = new DeviceRegistration(
                "0002",
                "switch",
                "http://localhost:9080/gateway/registry/devices/0001",
                10000,
                List.of("ESP8266", "SRD-05VDC-SL-C"));
        assertEquals("0001", command.getDeviceId());
        assertEquals(expected, command.getDeviceRegistration());
    }

    @Test
    void should_ThrowException_IfInputInvalid() {

        assertEquals("deviceId: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand(null, "0002",
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                10000,
                                List.of("ESP8266"))).getMessage());

        assertEquals("deviceRegistration.deviceId: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand("0001", null,
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                10000,
                                List.of("ESP8266"))).getMessage());

        assertEquals("deviceRegistration.deviceType: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand("0001", "0002",
                                null,
                                "http://localhost:9080/gateway/registry/devices/0001",
                                10000,
                                List.of("ESP8266"))).getMessage());

        assertEquals("deviceRegistration.deviceUri: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand("0001", "0002",
                                "switch",
                                null,
                                10000,
                                List.of("ESP8266"))).getMessage());

        assertEquals("deviceRegistration.statusUpdatePeriod: must not be null",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand("0001", "0002",
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                null,
                                List.of("ESP8266"))).getMessage());

        assertEquals("deviceRegistration.statusUpdatePeriod: must be greater than or equal to 0",
                assertThrows(ConstraintViolationException.class,
                        () -> new UpdateDeviceRegistrationCommand("0001", "0002",
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                -1,
                                List.of("ESP8266"))).getMessage());
    }
}
