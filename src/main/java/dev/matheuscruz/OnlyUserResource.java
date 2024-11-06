package dev.matheuscruz;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/only-user")
public class OnlyUserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"USER"})
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
