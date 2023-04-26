package dev.sergevas.cg.gateway.shared.adapter.in.web.hal;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Map;

@Component
public class HalBuilder {

    public HalBuilder appendSelf(Map<String, Object> links, URI selfUri) {
        links.put("self", new HalHref().href(selfUri));
        return this;
    }

    public HalBuilder appendEmbedded(Map<String, Object> embedded, String embeddedObjectName, Object embeddedObject) {
        embedded.put(embeddedObjectName, embeddedObject);
        return this;
    }
}
