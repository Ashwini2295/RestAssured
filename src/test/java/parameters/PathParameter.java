package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void getSingleProject()
	{
		//pre requisities
		baseURI="http://localhost:8084/";
		
		given()
		.pathParam("pid", "TY_PROJ_405")
		
		//Action
		.when()
		.get("/projects/{pid}")
		
		//Validation
		.then().log().all();
	}

}
