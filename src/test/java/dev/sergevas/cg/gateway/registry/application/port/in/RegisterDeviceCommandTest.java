package dev.sergevas.cg.gateway.registry.application.port.in;

import dev.sergevas.cg.gateway.registry.domain.DeviceRegistration;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterDeviceCommandTest {

    @Test
    void should_ReturnExpectedDeviceId_IfInputOk() {
        RegisterDeviceCommand command = new RegisterDeviceCommand(
                "0001",
                "switch",
                "http://localhost:9080/gateway/registry/devices/0001",
                10000,
                List.of("ESP8266", "SRD-05VDC-SL-C"));
        DeviceRegistration expected = new DeviceRegistration(
                "0001",
                "switch",
                "http://localhost:9080/gateway/registry/devices/0001",
                10000,
                List.of("ESP8266", "SRD-05VDC-SL-C"));
        assertEquals(expected, command.getDeviceRegistration());
    }

    @Test
    void should_ThrowException_IfDeviceRegistrationNull() {
        assertEquals("deviceRegistration.deviceId: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new RegisterDeviceCommand(null,
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                10000,
                                List.of("ESP8266"))).getMessage());
        assertEquals("deviceRegistration.deviceType: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new RegisterDeviceCommand("0001",
                                null,
                                "http://localhost:9080/gateway/registry/devices/0001",
                                10000,
                                List.of("ESP8266"))).getMessage());
        assertEquals("deviceRegistration.deviceUri: must not be blank",
                assertThrows(ConstraintViolationException.class,
                        () -> new RegisterDeviceCommand("0001",
                                "switch",
                                null,
                                10000,
                                List.of("ESP8266"))).getMessage());
        assertEquals("deviceRegistration.statusUpdatePeriod: must not be null",
                assertThrows(ConstraintViolationException.class,
                        () -> new RegisterDeviceCommand("0001",
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                null,
                                List.of("ESP8266"))).getMessage());
        assertEquals("deviceRegistration.statusUpdatePeriod: must be greater than or equal to 0",
                assertThrows(ConstraintViolationException.class,
                        () -> new RegisterDeviceCommand("0001",
                                "switch",
                                "http://localhost:9080/gateway/registry/devices/0001",
                                -10,
                                List.of("ESP8266"))).getMessage());
    }
}
