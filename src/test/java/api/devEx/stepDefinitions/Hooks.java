package api.devEx.stepDefinitions;


import api.devEx.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.*;


public class Hooks {
    @Before
    public void setUp() throws Exception {
     baseURI= ConfigurationReader.get("baseURL");
    }

    @After
    public void tearDown() throws Exception {
        reset();
    }
}
