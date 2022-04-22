package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.Projectlibrary;

public class StaticResponseValidationpost {
	@Test
	public void staticresponsevalidation()
	{
		//Step 1: pre requisites
		JavaLibrary jlib = new JavaLibrary();
		baseURI="http://localhost:8084/";
		
		Projectlibrary plib = new Projectlibrary("Ashwini", "Xylem "+jlib.getRandomNumber(), "Completed", 20);
		Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String actData = resp.jsonPath().get("projectId");
		
		Assert.assertEquals(actData, "TY_PROJ_803");
		System.out.println(actData);
		resp.then().log().all();
		
	}

}
