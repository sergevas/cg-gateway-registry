package dev.sergevas.cg.gateway.registry.domain;

import java.util.stream.Stream;

public enum DeviceStateType {
    ACTIVE("ACTIVE"),
    SLEEPING("SLEEPING"),
    STOPPED("STOPPED"),
    ERROR("ERROR");

    private String type;

    private DeviceStateType(String mode) {
        this.type = mode;
    }

    public String getType() {
        return type;
    }

    public static DeviceStateType fromTypeValue(final String typeValue) {
        return Stream.of(DeviceStateType.values())
                .filter(dt -> dt.getType().equals(typeValue))
                .findAny()
                .orElse(null);
    }
}
