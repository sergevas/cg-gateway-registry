package dev.sergevas.cg.gateway.registry.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class DeviceId {

    private String id;

    public String getId() {
        return id;
    }

    public DeviceId setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceId deviceId = (DeviceId) o;
        return Objects.equals(id, deviceId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DeviceId.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .toString();
    }
}
