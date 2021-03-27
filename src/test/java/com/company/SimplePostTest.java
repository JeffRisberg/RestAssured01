package com.company;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimplePostTest {

  @Test
  public void makeBasicPost() {
    RestAssured.baseURI = "http://www.scooterlabs.com/echo";

    Response response =
        given()
            .urlEncodingEnabled(true)
            .param("username", "user@site.com")
            .param("password", "Pas54321")
            .post()
            .then()
            .statusCode(200)
            .extract()
            .response();
  }

  @Test
  public void makePostWithNoBody() {
    RestAssured.baseURI = "http://www.scooterlabs.com/echo";

    Response response =
        given()
            .urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body("")
            .post()
            .then()
            .statusCode(200)
            .extract()
            .response();
  }

  @Test
  public void makePostWithBody() {
    RestAssured.baseURI = "http://www.scooterlabs.com/echo";

    String payload =
        "{\n"
            + "  \"description\": \"Some Description\",\n"
            + "  \"id\": \"Some id\",\n"
            + "  \"name\": \"Some name\"\n"
            + "}";

    Response response =
        given()
            .urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(payload)
            .post("")
            .then()
            .statusCode(200)
            .extract()
            .response();
  }
}
