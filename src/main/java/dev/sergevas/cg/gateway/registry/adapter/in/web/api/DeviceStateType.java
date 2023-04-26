package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Device possible states
 **/

/**
 * Device possible states
 */
public enum DeviceStateType {
    ACTIVE("ACTIVE"),
    SLEEPING("SLEEPING"),
    STOPPED("STOPPED"),
    ERROR("ERROR");

    private String value;

    DeviceStateType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DeviceStateType fromValue(String text) {
        for (DeviceStateType b : DeviceStateType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonProperty
    public String toString() {
        return String.valueOf(value);
    }
}
