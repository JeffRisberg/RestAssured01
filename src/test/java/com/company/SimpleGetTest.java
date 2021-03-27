package com.company;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SimpleGetTest {

  String apiKey = "e6f98c28900bb62e2b043c892277b7c0";

  String bostonName = "Boston";
  String bostonLat = "42.3584";
  String bostonLon = "-71.0598";

  @BeforeTest
  public static void setup() {
    RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
  }

  @Test
  public void getWeather() {
    // Using: api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    Response response =
        given()
            .param("q", bostonName)
            .param("appid", apiKey)
            .when()
            .get("/weather")
            .then()
            .extract()
            .response();

    assertEquals(response.statusCode(), 200, "Incorrect status code");

    assertEquals(response.jsonPath().getString("name"), bostonName, "incorrect latitude");

    assertEquals(response.jsonPath().getString("coord.lat"), bostonLat, "Incorrect latitude");
    assertEquals(response.jsonPath().getString("coord.lon"), bostonLon, "Incorrect longitude");
  }

  @Test
  public void getWeatherDetails() {
    // Using: api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    RequestSpecification httpRequest = given().param("q", bostonName).param("appid", apiKey);

    Response response = httpRequest.request(Method.GET, "/weather");

    String responseBody = response.getBody().asString();
    System.out.println("Response Body is =>  " + responseBody);
  }

  @Test
  public void getWeatherDetailsInvalidCity() {
    // Using: api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    RequestSpecification httpRequest = given().param("q", "zigamorph").param("appid", apiKey);

    Response response = httpRequest.get("/weather");

    int statusCode = response.getStatusCode();
    assertEquals(404, statusCode, "Incorrect status code");
  }
}
