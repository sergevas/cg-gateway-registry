package dev.sergevas.cg.gateway.registry.application.port.in;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteRegisteredDeviceCommandTest {

    @Test
    void should_ReturnExpectedDeviceId_IfInputOk() {
        DeleteRegisteredDeviceCommand command = new DeleteRegisteredDeviceCommand("0001");
        assertEquals("0001", command.getDeviceId());
    }

    @Test
    void should_ThrowException_IfDeviceIdNull() {
        assertEquals("deviceId: must not be blank", assertThrows(ConstraintViolationException.class,
                () -> new DeleteRegisteredDeviceCommand(null)).getMessage());
    }
}
