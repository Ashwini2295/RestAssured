package responseValidation;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.Projectlibrary;

public class StaticResponseValidationGet {
	@Test
	public void staticresponsevalidationget()
	{
		//Step 1: pre requisites
		String expData = "Zomato";
		baseURI="http://localhost:8084/";
		
		//perform action
		
		Response resp = when().get("projects");
		
		//validation
		
		String actData = resp.jsonPath().get("[0].createdBy");
		Assert.assertEquals(actData, expData);
		System.out.println("Data verified");
		
		resp.then().log().all(); 
	}

}
