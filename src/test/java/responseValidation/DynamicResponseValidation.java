package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	@Test
	public void dynamicResponsevalidation()
	{
		//Prerequisites
		String expData = "TY_PROJ_405";
		baseURI="http://localhost:8084/";
		
		//perform action
		
		Response resp = when().get("projects");
		
		//validation
		Boolean flag = false;
		List<String> pIDs = resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data verified");
		resp.then().log().all();
	}

}
