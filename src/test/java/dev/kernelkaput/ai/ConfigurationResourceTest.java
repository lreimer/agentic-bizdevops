package dev.kernelkaput.ai;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class ConfigurationResourceTest {

    @Test
    void testGetAllConfigurations() {
        given()
            .when().get("/api/configurations")
            .then()
                .statusCode(200)
                .body(containsString("openai.api.key"))
                .body(containsString("master.password"))
                .body(containsString("app.version"));
    }

    @Test
    void testGetConfigurationByKey() {
        given()
            .when().get("/api/configurations/app.version")
            .then()
                .statusCode(200)
                .body("key", is("app.version"))
                .body("value", is("1.0.0"))
                .body("description", notNullValue());
    }

    @Test
    void testGetNonExistentConfiguration() {
        given()
            .when().get("/api/configurations/non.existent.key")
            .then()
                .statusCode(404);
    }
}
