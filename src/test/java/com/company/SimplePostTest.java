package com.company;

import io.restassured.RestAssured;
import org.junit.Test;

public class SimplePostTest {

  @Test
  public void GetWeatherDetails() {
    // Specify the base URL to the RESTful web service
    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

  }
}
