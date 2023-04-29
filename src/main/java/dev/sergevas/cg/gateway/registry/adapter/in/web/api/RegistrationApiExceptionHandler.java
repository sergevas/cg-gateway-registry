package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import dev.sergevas.cg.gateway.registry.application.port.in.DeviceAlreadyRegisteredException;
import dev.sergevas.cg.gateway.registry.application.port.in.DeviceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationApiExceptionHandler {

    @ExceptionHandler(value = DeviceNotFoundException.class)
    public ResponseEntity deviceNotFoundException(DeviceNotFoundException e) {
        return new ResponseEntity(new Error()
                .errorCode("C-0001")
                .errorMsg(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DeviceAlreadyRegisteredException.class)
    public ResponseEntity deviceAlreadyRegisteredException(DeviceAlreadyRegisteredException e) {
        return new ResponseEntity(new Error()
                .errorCode("C-0002")
                .errorMsg(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity runtimeException(RuntimeException e) {
        return new ResponseEntity(new Error().errorCode("E-0001")
                .errorMsg(new StringBuilder("Runtime error: [")
                        .append(e.getMessage())
                        .append("]").toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity runtimeException(ConstraintViolationException e) {
        return new ResponseEntity(new Error()
                .errorCode("V-0001")
                .errorMsg(new StringBuilder("Validation error: [")
                        .append(e.getMessage())
                        .append("]")
                        .toString()), HttpStatus.BAD_REQUEST);
    }
}
