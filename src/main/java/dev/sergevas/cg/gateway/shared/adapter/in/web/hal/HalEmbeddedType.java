package dev.sergevas.cg.gateway.shared.adapter.in.web.hal;

import jakarta.json.bind.annotation.JsonbProperty;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class HalEmbeddedType {

    @JsonbProperty("_links")
    private Map<String, URI> links = new HashMap<>();

    public HalEmbeddedType links(Map<String, URI> links) {
        this.links = links;
        return this;
    }

    @JsonbProperty("_links")
    public Map<String, URI> getLinks() {

        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HalEmbeddedType that = (HalEmbeddedType) o;
        return Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HalEmbeddedType.class.getSimpleName() + "[", "]")
                .add("links=" + links)
                .toString();
    }
}
