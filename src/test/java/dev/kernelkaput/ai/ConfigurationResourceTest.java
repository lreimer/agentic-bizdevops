package dev.kernelkaput.ai;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
class ConfigurationResourceTest {

    @Test
    void testGetAllConfigItems() {
        given()
            .when().get("/config")
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", hasSize(5))
                .body("key", hasItems("openai.api.key", "master.password", "app.name", "app.version", "app.environment"));
    }

    @Test
    void testGetConfigItem() {
        given()
            .when().get("/config/app.name")
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("key", is("app.name"))
                .body("value", is("Agentic BizDevOps"));
    }

    @Test
    void testGetConfigItemNotFound() {
        given()
            .when().get("/config/non.existent.key")
            .then()
                .statusCode(404);
    }

    @Test
    void testUpdateConfigItem() {
        ConfigurationItem item = new ConfigurationItem("app.environment", "testing");

        // Update the config item
        given()
            .contentType(ContentType.JSON)
            .body(item)
            .when().put("/config/app.environment")
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("key", is("app.environment"))
                .body("value", is("testing"));

        // Verify the update was successful
        given()
            .when().get("/config/app.environment")
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("key", is("app.environment"))
                .body("value", is("testing"));
    }

    @Test
    void testUpdateConfigItemKeyMismatch() {
        ConfigurationItem item = new ConfigurationItem("wrong.key", "value");

        given()
            .contentType(ContentType.JSON)
            .body(item)
            .when().put("/config/app.environment")
            .then()
                .statusCode(400);
    }
}
