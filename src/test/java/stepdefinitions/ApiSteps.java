package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ApiSteps {

    public static final String BASE_URL = "https://reqres.in";
    private String endPoint = "/api/users?page=1";
    private Response response;
    private String userId;

    @Given("I have access to the API")
    public void iHaveAccessToTheAPI() {
        RestAssured.baseURI = BASE_URL;
    }

    @Given("The Api endpoint for getting list of user is {string}")
    public void the_api_endpoint_for_getting_list_of_user_is(String getUserEndPoint) {
        endPoint = getUserEndPoint;
    }

    @When("I send a GET request to the endpoint")
    public void i_send_a_get_request_to_the_endpoint() {
        response = RestAssured.given().get(endPoint);

    }

    @Then("I should get a {int} response code")
    public void i_should_get_a_response_code(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());

    }

    //SC:2
    @When("The Api post endpoint for getting list of user is {string}")
    public void the_api_post_endpoint_for_getting_list_of_user_is(String postEndpoint) {
        endPoint = postEndpoint;
    }

    @When("I send a POST request to the endpoint with the body")
    public void i_send_a_post_request_to_the_endpoint_with_the_body() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Sruthi");
        requestBody.put("job", "Tester");

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endPoint);

        userId = response.jsonPath().getString("id");
    }

    @Then("I should get a {int} status code")
    public void i_should_get_a_status_code(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("The response should contain the name and job")
    public void the_response_should_contain_the_name_and_job() {
        Assert.assertEquals(response.jsonPath().getString("name"), "Sruthi");
        Assert.assertEquals(response.jsonPath().getString("job"), "Tester");
    }

    //Sc3:
    @When("I send a PUT request to update the user with the body")
    public void i_send_a_put_request_to_update_the_user_with_the_body() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Sruthi S");
        requestBody.put("job", "Test Automation Engineer");

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/api/users/" + userId);
    }

    @Then("The response should contain the updated name and job")
    public void the_response_should_contain_the_updated_name_and_job() {
        Assert.assertEquals(response.jsonPath().getString("name"), "Sruthi S");
        Assert.assertEquals(response.jsonPath().getString("job"), "Test Automation Engineer");
    }

    @When("I send a DELETE request to delete the user")
    public void i_send_a_delete_request_to_delete_the_user() {
        response = RestAssured.given().delete("/api/users/" + userId);
    }

    @Then("I should get a {int} status code for delete")
    public void i_should_get_a_status_code_for_delete(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

}


