package dev.sergevas.cg.gateway.shared.adapter.in.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@ApplicationScoped
public class HalBuilder {

    public HalBuilder apendSelf(HalType halType, URI selfUri) {
        halType.getLinks().put("self", selfUri);
        return this;
    }
}
