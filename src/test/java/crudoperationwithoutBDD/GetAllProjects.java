package crudoperationwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects 
{
	@Test
	public void getallprojects()
	{
		//step1: create pre requisites
		
				//step 2: perform action
				Response resp = RestAssured.get("http://localhost:8084/projects");
				
				//step 3: validation
				resp.then().log().all();
				int actstmt = resp.getStatusCode();
				Assert.assertEquals(actstmt, 200);
	}

}
