package dev.sergevas.cg.gateway;

import cloud.piranha.embedded.EmbeddedPiranha;
import cloud.piranha.embedded.EmbeddedPiranhaBuilder;
import cloud.piranha.http.impl.DefaultHttpServer;
import cloud.piranha.http.webapp.HttpWebApplicationServerProcessor;
import dev.sergevas.cg.gateway.registry.adapter.in.web.api.RegistrationApi;
import org.jboss.weld.environment.se.Weld;


public class CgGatewayApp {

    public static void main(String[] args) {
        Weld weld = new Weld();
        EmbeddedPiranha piranha = new EmbeddedPiranhaBuilder()
                .servlet("RegistrationApi", RegistrationApi.class)
                .servletMapping("RegistrationApi", "registry/devices/*")
                .buildAndStart();

        DefaultHttpServer defaultHttpServer = new DefaultHttpServer(8080,
                new HttpWebApplicationServerProcessor(piranha), false);

//        NettyHttpServer nettyHttpServer = new NettyHttpServer(8081,
//                new HttpWebApplicationServerProcessor(piranha));

        defaultHttpServer.start();

    }
}
