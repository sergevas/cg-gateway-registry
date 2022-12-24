package dev.sergevas.cg.gateway.shared.adapter.in.web;

import jakarta.json.bind.annotation.JsonbProperty;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class HalType {

    private Map<String, URI> links = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T extends HalType> T links(Map<String, URI> links) {
        this.links = links;
        return (T) this;
    }

    @JsonbProperty("_links")
    public Map<String, URI> getLinks() {

        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HalType halType = (HalType) o;
        return Objects.equals(links, halType.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HalType.class.getSimpleName() + "[", "]")
                .add("links=" + links)
                .toString();
    }
}
