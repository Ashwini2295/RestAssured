package crudoperationwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		//Step1: Create the pre requisites -- request body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Ashwini");
		jObj.put("projectName", "Xylem");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//Step 2: Perform the Action
		
		Response resp = req.post("http://localhost:8084/addProject");
		
		
		//Step 3: Validate the response
		System.out.println(resp.getContentType());
		System.out.println(resp.asString());
		System.out.println(resp.prettyPeek());
		
	}

}
