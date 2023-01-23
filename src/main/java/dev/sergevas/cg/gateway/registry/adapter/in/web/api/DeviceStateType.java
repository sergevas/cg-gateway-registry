package dev.sergevas.cg.gateway.registry.adapter.in.web.api;

//import jakarta.json.bind.annotation.JsonbCreator;
//import jakarta.json.bind.annotation.JsonbProperty;

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

    @Override
//    @JsonbProperty
    public String toString() {
        return String.valueOf(value);
    }

//    @JsonbCreator
    public static DeviceStateType fromValue(String text) {
        for (DeviceStateType b : DeviceStateType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
