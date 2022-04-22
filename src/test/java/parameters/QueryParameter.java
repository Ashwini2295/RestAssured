package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void queryparameter()
	{
		//pre requisities
		baseURI="https://reqres.in/";
		
		given()
		.queryParam("page", 3)
		
		//Action
		.when()
		.get("api/users")
		
		//Validation
		.then().log().all();
	}


}
