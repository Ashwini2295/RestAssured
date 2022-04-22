package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 
{
	@Test
	public void oauthAuthentication()
	{
		//create a request to generate token
		Response resp = given()
		.formParam("client_id", "SDET-30Coops")
		.formParam("client_secret", "e97ea91e2a7e289cf0ccc8586554ae1d")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "authorization_code")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//Capture the aceess token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Create another request and use the token to access the APIs
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3126)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
		.then().log().all();
		
	}

}
