package api.devEx.stepDefinitions;

import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static api.devEx.requests.DevExRequest.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Profile_stepDefs {
    //Response response;
    @When("The user sends a GET request and able to see all profiles")
    public void the_user_sends_a_get_request_and_able_to_see_all_profiles() {
      response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("retrieve_all_profiles"));
        response.prettyPrint();

    }
    @Then("The user verifies that status code is {int}")
    public void the_user_verifies_that_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }
    @When("The user sends a GET request and able to see all profiles second way")
    public void the_user_sends_a_get_request_and_able_to_see_all_profiles_second_way() {
        //response= DevExRequest.getAllProfile();
       getAllProfile();
    }

    @When("The user sends a GET request with {int}")
    public void the_user_sends_a_get_request_with(int userID) {
           getOneUserWithPathParam(userID);
           response.prettyPrint();
    }
    @Then("The user verifies that user's info  name is {string} and company is {string} and location is {string} and email is {string}")
    public void the_user_verifies_that_user_s_info_name_is_and_company_is_and_location_is_and_email_is(String expectedName,
                                                            String expectedCompany, String expctedLocation, String expectedEmail) {
        System.out.println("response.path(\"user.name\") = " + response.path("user.name"));
        System.out.println("response.path(\"company\") = " + response.path("company"));
        System.out.println("response.path(\"location\") = " + response.path("location"));
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));

        String actualName=response.path("user.name");
        String actualCompany=response.path("company");
        String actualLocation=response.path("location");
        String actualEmail=response.path("user.email");

        assertEquals(expectedName,actualName);
        assertEquals(expectedCompany,actualCompany);
        assertEquals(expctedLocation,actualLocation);
        assertEquals(expectedEmail,actualEmail);
    }
    @When("The user sends a POST request with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_sends_a_post_request_with_and_and_and_and_and_and_and_and_and_and(String company,
                                                                                           String website,String location,String status,
                                                                                           String skills,String githubusername,String youtube,
                                                                                           String twitter,String facebook,String linkedin,String instagram) {
        postSaveProfile(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram);
    }
    @Then("The user verifies that name as {string} and email as {string}")
    public void the_user_verifies_that_name_as_and_email_as(String expectedName, String expectedEmail) {
        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedEmail,response.path("user.email"));
    }
}
