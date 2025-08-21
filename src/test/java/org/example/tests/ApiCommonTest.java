package org.example.tests;

import io.restassured.response.Response;
import org.example.utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;

public class ApiCommonTest {
    public static Response getUserById(int id) {
        String baseUrl = ConfigReader.get("apibaseUrl");
        String headerKey = ConfigReader.get("apiheaderKey");
        String headerValue = ConfigReader.get("apiheaderValue");
        return given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .pathParam("id", id)
                .when()
                .get("/users/{id}")
                .then()
                .log().body()
                .extract()
                .response();


    }

}








