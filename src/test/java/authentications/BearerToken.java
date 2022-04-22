package authentications;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com/";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "xyzzzzzz");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
	}

}
