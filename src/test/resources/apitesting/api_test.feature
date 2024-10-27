Feature: Api Functionality check

  Background:
    Given I have access to the API

  @Get
  Scenario: Get List of Users
    When The Api endpoint for getting list of user is "/api/users?page=1"
    Then  I send a GET request to the endpoint
    Then I should get a 200 response code

  @Post
    Scenario: Post a new user
      When The Api post endpoint for getting list of user is "/api/users"
      And I send a POST request to the endpoint with the body
      Then I should get a 201 status code
      And The response should contain the name and job
   @Put
     Scenario: Update a user
       When I send a PUT request to update the user with the body
       Then I should get a 200 status code
       And The response should contain the updated name and job

    @Delete
    Scenario: Delete a user
      When I send a DELETE request to delete the user
      Then I should get a 204 status code for delete