package dev.sergevas.cg.gateway.shared.adapter.in.web;

import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.util.Map;

@ApplicationScoped
public class HalBuilder {

    public HalBuilder appendSelf(Map<String, URI> links, URI selfUri) {
        links.put("self", selfUri);
        return this;
    }
}
