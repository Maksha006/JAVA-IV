package helb.smakani.service;

import be.helb.smakani.model.Traveler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(SpringExtension.class)
public class TravelerIntegrationTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @Test
    public void whenRequestedPost_thenCreated() {

        Traveler travelerToCreate = new Traveler(11111L, "Shaya", "Makani", "shaya@makani.com");

        given()
                .contentType(ContentType.JSON)
                .body(travelerToCreate)
                .when()
                .post("/createTraveler")
                .then()
                .statusCode(201)
                .body("firstName", equalTo(travelerToCreate.getFirstName()))
                .body("lastName", equalTo(travelerToCreate.getLastName()))
                .body("email", equalTo(travelerToCreate.getEmail()));
    }


}
