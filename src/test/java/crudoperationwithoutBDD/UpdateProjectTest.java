package crudoperationwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	public void updateProjectTest()
	{
		//Step1: Create the pre requisites -- request body
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "Ashwini");
				jObj.put("projectName", "Xylem");
				jObj.put("status", "Ongoing");
				jObj.put("teamSize", 22);
				
				
				RequestSpecification req = RestAssured.given();
				req.body(jObj);
				req.contentType(ContentType.JSON);
				
				//Step 2: Perform the Action
				
				Response resp = req.put("http://localhost:8084/projects/TY_PROJ_602");
				
				
				//Step 3: Validate the response
				resp.then().log().all();
				int actStmt = resp.getStatusCode();
				Assert.assertEquals(actStmt, 200);
	}

}
