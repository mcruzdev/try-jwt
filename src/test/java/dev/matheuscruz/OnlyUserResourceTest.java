package dev.matheuscruz;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class OnlyUserResourceTest {

    @Test
    void testHelloEndpoint() {

        var token = Jwt.upn("jdoe@quarkus.io")
                .issuer("https://quarkus.io/issuer")
                .groups("USER")
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();

        given()
                .header(new Header("Authorization", "Bearer " + token))
                .when().get("/only-user")
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus REST"));
    }

}