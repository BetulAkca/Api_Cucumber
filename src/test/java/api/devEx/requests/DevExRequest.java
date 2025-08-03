package api.devEx.requests;

import api.devEx.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.devEx.common.DataForApi.*;
import static io.restassured.RestAssured.given;

public class DevExRequest {
   public static Response response;
   public static String token;
    public static Response getAllProfile(){
       response = given().accept(ContentType.JSON)
                .when()
                .get(ConfigurationReader.get("retrieve_all_profiles"));
        response.prettyPrint();
        return response;
    }
    public static Response getOneUserWithPathParam(int userID){
        response=given().accept(ContentType.JSON)
                .and()
                .pathParam("id",userID)
                .when()
                .get(ConfigurationReader.get("get_user_profile_by_id"));
        return response;
    }

    public static Response registerNewUser(String email,
                           String password,String name,String google,String facebook,String github){

         response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("register_user"));
         token =response.path("token");
         return response;
    }

    public static Response postSaveProfile(String company,
                                           String website,String location,String status,
                                           String skills,String githubusername,String youtube,
                                           String twitter,String facebook,String linkedin,String instagram){
        response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",ConfigurationReader.get("newUserToken"))
                .and()
                .body(saveProfileBody(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram))
                .when()
                .post(ConfigurationReader.get("post_Save_Profile"));

        response.prettyPrint();
        return response;
    }
    public static Response postExperience(String title,String company,
                                          String location,String from,
                                          String to,String current,String description){
        response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("x-auth-token",ConfigurationReader.get("postLoginToken"))
                .and()
                .body(addExperienceBody(title, company, location, from, to, current, description))
                .when()
                .post(ConfigurationReader.get("post_experience"));
        response.prettyPrint();
        return response;
    }

}
