package com.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DrunkDrivingTest {

    @Test
    public void HeavyDrunkenTest() {
        given()
                .body("{\"drunkDrivings\":[{\"alcohol\":0.25}]}")
                .contentType(ContentType.JSON)
            .when()
                .post("/drunk-driving")
            .then()
                .statusCode(200)
                .body("point", is(Arrays.asList(25)));
    }
    @Test
    public void MediumDrunkenTest() {
        given()
                .body("{\"drunkDrivings\":[{\"alcohol\":0.15}]}")
                .contentType(ContentType.JSON)
            .when()
                .post("/drunk-driving")
            .then()
                .statusCode(200)
                .body("point", is(Arrays.asList(13)));
    }
    @Test
    public void LightDrunkenTest() {
        given()
                .body("{\"drunkDrivings\":[{\"alcohol\":0.05}]}")
                .contentType(ContentType.JSON)
            .when()
                .post("/drunk-driving")
            .then()
                .statusCode(200)
                .body("point", is(Arrays.asList(0)));
    }

    //@Test
    public void AllDrunkenTest() {
        given()
                .body("{\"drunkDrivings\":[{\"alcohol\":0.05},{\"alcohol\":0.15},{\"alcohol\":0.25}]}")
                .contentType(ContentType.JSON)
            .when()
                .post("/drunk-driving")
            .then()
                .statusCode(200)
                .body("point", is(Arrays.asList(25,13,0)));
    }
}
