package com.company;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SimplePostTest {

  private static String payload = "{\n" +
    "  \"description\": \"Some Description\",\n" +
    "  \"id\": \"Some id\",\n" +
    "  \"name\": \"Some name\"\n" +
    "}";

  @Test
  public void GetWeatherDetails() {
    RestAssured.baseURI = "https://www.example.com";

    given().urlEncodingEnabled(true)
      .param("username", "user@site.com")
      .param("password", "Pas54321")
      .header("Accept", ContentType.JSON.getAcceptHeader())
      .post("/login")
      .then().statusCode(200);
  }

  @Test
  public void MakePostWithBody() {
    RestAssured.baseURI = "https://www.example.com";

    given()
      .contentType(ContentType.JSON)
      .body(payload)
      .post("/some/resource")
      .then()
      .statusCode(200)
      .extract()
      .response();
  }
}
