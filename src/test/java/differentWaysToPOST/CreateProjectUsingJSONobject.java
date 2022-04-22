package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONobject {
	@Test
	public void createprojectusingjson()
	{
		JavaLibrary jlib = new JavaLibrary();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Ashwini");
		jObj.put("projectName", "States "+jlib.getRandomNumber());
		jObj.put("stats", "Completed");
		jObj.put("teamSize", 12);
		
		baseURI="http://localhost:8084/";
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
	

}
