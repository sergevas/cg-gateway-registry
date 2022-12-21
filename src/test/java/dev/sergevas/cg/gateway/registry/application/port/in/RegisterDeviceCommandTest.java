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
        ConstraintViolationException cve = assertThrows(ConstraintViolationException.class,
                () -> new RegisterDeviceCommand(null, null,
                        null, null, null));
        assertEquals("deviceRegistration.deviceId: must not be blank, deviceRegistration.deviceUri: must not be blank, deviceRegistration.deviceType: must not be blank", cve.getMessage());
    }
}
