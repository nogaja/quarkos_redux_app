package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import javax.ws.rs.core.MediaType;




@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body("content", equalTo("Hello"));
    }


    @Test
    public void testPostMsgEndpoint() {
        // create a test message
        Message testMessage = new Message("test message");

        // post the message to the endpoint
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(testMessage)
        .when()
            .post("/hello")
        .then()
            .statusCode(204);
    }


}