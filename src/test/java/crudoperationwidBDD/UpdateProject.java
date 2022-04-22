package crudoperationwidBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProject 
{
	@Test
	public void updateProject()
	
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
				.put("projects/TY_PROJ_604")
				
				.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
	}
	

}
