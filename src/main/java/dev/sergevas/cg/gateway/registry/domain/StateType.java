package dev.sergevas.cg.gateway.registry.domain;

import java.util.stream.Stream;

public enum StateType {
    ACTIVE("ACTIVE"),
    SLEEPING("SLEEPING"),
    STOPPED("STOPPED"),
    ERROR("ERROR");

    private String type;

    private StateType(String mode) {
        this.type = mode;
    }

    public String getType() {
        return type;
    }

    public static StateType fromTypeValue(final String typeValue) {
        return Stream.of(StateType.values())
                .filter(dt -> dt.getType().equals(typeValue))
                .findAny()
                .orElse(null);
    }
}
