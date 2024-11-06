package dev.matheuscruz;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Path("/token")
public class TokenResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String hello() {
        return Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .expiresIn(Duration.ofDays(30))
                .groups(new HashSet<>(List.of("USER")))
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
    }
}
