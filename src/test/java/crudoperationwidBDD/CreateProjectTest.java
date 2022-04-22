package crudoperationwidBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	@Test
	public void createproject()
	{
	
		//step 1: create pre requisites
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Ashwini");
		jObj.put("projectName", "States155454");
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
