package api.devEx.stepDefinitions;

import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static api.devEx.requests.DevExRequest.*;
import static org.junit.Assert.assertTrue;

public class SignUp_stepDefs {
    @When("The user sends a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_sends_a_post_request_with_and_and_and_and_and(String email,
                                             String password,String name,String google,String facebook,String github) {
        registerNewUser(email, password, name, google, facebook, github);
        response.prettyPrint();
    }
    @Then("The user verifies that body contains {string}")
    public void the_user_verifies_that_body_contains(String token) {
        assertTrue(response.body().asString().contains(token));
    }

    @And("The compiler gets the token")
    public void theCompilerGetsTheToken() {
        //System.out.println("token = " + token);
        ConfigurationReader.set("newUserToken",token);
    }
}
