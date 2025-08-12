package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;



public class ApiTest {
    @Test
    public void testGet() {
        RestAssured.baseURI = "https://reqres.in/api";
       Response resp = given()
             .log().all()
               .pathParam("id",5)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("/users/{id}")
                .then()
                 .log().body()
                 .assertThat()
                 .statusCode(200)
                 .extract()
                 .response();
 // System.out.println(resp.asString());
        int actualId = resp.jsonPath().getInt("data.id");
        Assert.assertEquals(actualId, 5);

    }
}
