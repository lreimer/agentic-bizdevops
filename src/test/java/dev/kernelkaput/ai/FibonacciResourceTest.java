package dev.kernelkaput.ai;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class FibonacciResourceTest {

    @Test
    void testMissingPositionParameter() {
        given()
            .when().get("/fibonacci")
            .then()
                .statusCode(400)
                .body(is("Query parameter 'position' is required"));
    }

    @Test
    void testNegativePositionParameter() {
        given()
            .when().get("/fibonacci?position=-1")
            .then()
                .statusCode(400)
                .body(is("Position must be non-negative"));
    }

    @Test
    void testZeroPositionParameter() {
        given()
            .when().get("/fibonacci?position=0")
            .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    void testPosition10Parameter() {
        given()
            .when().get("/fibonacci?position=10")
            .then()
                .statusCode(200)
                .body(is("55"));
    }
}
