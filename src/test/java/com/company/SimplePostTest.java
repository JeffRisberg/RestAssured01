package com.company;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimplePostTest {

  private static String payload =
      "{\n"
          + "  \"description\": \"Some Description\",\n"
          + "  \"id\": \"Some id\",\n"
          + "  \"name\": \"Some name\"\n"
          + "}";

  @Test
  public void MakeBasicPost() {
    RestAssured.baseURI = "https://www.postman-echo.com";

    Response response =
        given()
            .urlEncodingEnabled(true)
            .param("username", "user@site.com")
            .param("password", "Pas54321")
            .header("Accept", "*/*")
            .post("/post")
            .then()
            //.statusCode(200)
            .extract()
            .response();
    System.out.println(response.body().print());
  }

  @Test
  public void MakePostWithBody() {
    RestAssured.baseURI = "https://www.postman-echo.com";

    Response response =
        given()
            .urlEncodingEnabled(true)
            .contentType(ContentType.JSON)
            .body(payload)
            .post("/post")
            .then()
            .statusCode(200)
            .extract()
            .response();
  }
}
