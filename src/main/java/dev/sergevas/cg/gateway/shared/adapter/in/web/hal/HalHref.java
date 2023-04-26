package dev.sergevas.cg.gateway.shared.adapter.in.web.hal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.util.Objects;
import java.util.StringJoiner;

public class HalHref {

    @JsonProperty("href")
    private URI href;

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }

    public HalHref href(URI href) {
        this.href = href;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HalHref halHref = (HalHref) o;
        return Objects.equals(href, halHref.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HalHref.class.getSimpleName() + "[", "]")
                .add("href='" + href + "'")
                .toString();
    }
}
