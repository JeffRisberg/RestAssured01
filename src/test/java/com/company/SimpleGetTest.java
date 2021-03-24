package com.company;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SimpleGetTest {

    @BeforeTest
    public static void setup() {
      RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequest() {
      Response response = given()
              .contentType(ContentType.JSON)
              .when()
              .get("/posts")
              .then()
              .extract().response();

      assertEquals(200, response.statusCode());
      assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

  //@Test
  public void GetWeatherDetails() {
    // Specify the base URL to the RESTful web service
    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

    // Get the RequestSpecification of the request that you want to sent
    // to the server. The server is specified by the BaseURI that we have
    // specified in the above step.
    RequestSpecification httpRequest = given();

    // Make a request to the server by specifying the method Type and the method URL.
    // This will return the Response from the server. Store the response in a variable.
    Response response = httpRequest.request(Method.GET, "/Hyderabad");

    // Now let us print the body of the message to see what response
    // we have recieved from the server
    String responseBody = response.getBody().asString();
    System.out.println("Response Body is =>  " + responseBody);
  }

  //@Test
  public void GetMoreWeatherDetails() {
    // Specify the base URL to the RESTful web service
    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

    // Get the RequestSpecification of the request that you want to sent
    // to the server. The server is specified by the BaseURI that we have
    // specified in the above step.
    RequestSpecification httpRequest = given();

    // Make a request to the server by specifying the method Type and the method URL.
    // This will return the Response from the server. Store the response in a variable.
    Response response = httpRequest.request(Method.GET, "/Mumbai");

    // Now let us print the body of the message to see what response
    // we have recieved from the server
    String responseBody = response.getBody().asString();
    System.out.println("Response Body is =>  " + responseBody);
  }

  //@Test
  public void GetWeatherDetailsInvalidCity() {
    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
    RequestSpecification httpRequest = given();
    Response response = httpRequest.get("/78789798798");
    int statusCode = response.getStatusCode();
    assertEquals(200, statusCode, "Correct status code returned");
  }

  //@Test
  public void example() {

      /*
    when().
      get("http://restapi.demoqa.com/utilities/weather/city/{city}", "Hyderabad").
      then().
      statusCode(200).
      body("City", equalTo("Hyderabad"),
        "Temperature", endsWith("celsius"));
       */
  }

  //@Test
  public void Get() {

// JSONObject is a class that represents a Simple JSON.
// We can add Key - Value pairs using the put method
    JSONObject requestParams = new JSONObject();
    requestParams.put("FirstName", "Virender");
    requestParams.put("LastName", "Singh");

    requestParams.put("UserName", "simpleuser001");
    requestParams.put("Password", "password1");
    requestParams.put("Email", "someuser@gmail.com");
  }
}
