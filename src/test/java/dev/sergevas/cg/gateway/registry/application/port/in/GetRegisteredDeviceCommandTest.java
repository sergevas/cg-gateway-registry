package dev.sergevas.cg.gateway.registry.application.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetRegisteredDeviceCommandTest {

    @Test
    void should_ReturnExpectedDeviceId_IfInputOk() {
        GetRegisteredDeviceCommand command = new GetRegisteredDeviceCommand("0001");
        assertEquals("0001", command.getDeviceId());
    }

    @Test
    void should_ThrowException_IfDeviceIdNull() {
        ConstraintViolationException cve = assertThrows(ConstraintViolationException.class,
                () -> new GetRegisteredDeviceCommand(null));
        assertEquals("deviceId: must not be blank", cve.getMessage());
    }

}