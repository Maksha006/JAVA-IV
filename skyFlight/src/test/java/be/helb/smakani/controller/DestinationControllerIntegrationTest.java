package be.helb.smakani.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
public class DestinationControllerIntegrationTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8180";
    }

    @Test
    public void when_get_books_with_no_argument_then_status_200_and_not_empty() {
        RestAssured.with()
                .contentType(ContentType.JSON)
                .when()
                .get("/allDestinations")
                .then()
                .statusCode(200)
                //.body("", not(empty())) // Asserts that the response is not an empty list or object
                .body("[0].airportCode", equalTo("MXP")) // Asserts that the title of the first book in the list is "The Great Gatsby"
                .body("[0].cityName", equalTo("paris")) // Asserts the author of the first book
                .body("size()", greaterThan(0)); // Asserts that there is at least one book in the list
    }
}
