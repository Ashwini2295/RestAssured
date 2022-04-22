package crudoperationwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
	@Test
	public void getsingleproject()
	{
		//step1: create pre requisites
		
		//step 2: perform action
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_602");
		
		//step 3: validation
		resp.then().log().all();
		int actstmt = resp.getStatusCode();
		Assert.assertEquals(actstmt, 200);

	}
	
}
