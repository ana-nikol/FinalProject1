package org.example.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest {
    @Test
    /* ტესტი ამოწმებს GET მოთხოვნას ID = 5-ით. ვაგზავნი მოთხოვნას /users/5-ზე.
     ვამოწმებ, რომ სტატუს კოდი არის 200.
    ვამოწმებ, რომ დაბრუნებული id არის 5. */
    public void testGetUser() {
        int userid = 5;
        int expectedStatus = 200;
        Response response = ApiCommonTest.getUserById(userid);
        Assert.assertEquals(response.getStatusCode(), expectedStatus);
        int actualId = response.jsonPath().getInt("data.id");
        Assert.assertEquals(actualId, userid);

    }
}