package api.devEx.stepDefinitions;

import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static api.devEx.requests.DevExRequest.postExperience;
import static api.devEx.utilities.ApiUtils.getAccessToken;

public class Experience_stepDefs {
    @Given("The user sends a POST request and login with {string} and {string}")
    public void the_user_sends_a_post_request_and_login_with_and(String email, String password) {
        ConfigurationReader.set("postLoginToken", getAccessToken(email, password));
    }
    @When("The user sends a POST request for adding an experience with {string} {string} {string} {string} {string} {string} {string}")
    public void the_user_sends_a_post_request_for_adding_an_experience_with(String title,String company,
                                                                            String location,String from,
                                                                            String to,String current,String description) {
        postExperience(title, company, location, from, to, current, description);
    }
}
