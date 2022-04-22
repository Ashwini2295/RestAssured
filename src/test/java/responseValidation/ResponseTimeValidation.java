package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ResponseTimeValidation 
{
	@Test
	public void responsetimeValidation()
	{
		//Prerequistes
		baseURI="http://localhost:8084/";
		
		//action performed
		  Response resp = when().get("projects");
		
		//validation
		resp.then()
		.assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
		.log().all();
		long ti = resp.time();
		System.out.println(ti);
	} 

}
