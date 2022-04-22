package crudoperationwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject 
{
	@Test
	public void deleteproject()
	{
		//step1: create pre requisites
		
				//step 2: perform action
				Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_602");
				
				//step 3: validation
				resp.then().log().all();
				int actstmt = resp.getStatusCode();
				Assert.assertEquals(actstmt, 204);
	}

}
