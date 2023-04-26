package dev.sergevas.cg.gateway.proxy.adapter.in.web;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("proxy/devices")
public class ProxyApi {

    @GetMapping(path = "/{deviceId}/{deviceResource}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> getOnDeviceResource(@PathVariable("deviceId") String deviceId,
                                                      @PathVariable("deviceResource") String deviceResource) {
        return ResponseEntity.ok("magic!");
    }

    @PostMapping(path = "/{deviceId}/{deviceResource}", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> postOnDeviceResource(@PathVariable("deviceId") String deviceId,
                                                       @PathVariable("deviceResource") String deviceResource,
                                                       @Valid @RequestBody Object body) {
        return ResponseEntity.ok("magic!");
    }
}
