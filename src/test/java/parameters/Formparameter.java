package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Formparameter {
	@Test
	public void createprojectusingformparameter()
	{
		//pre requisities
		baseURI="http://localhost:8084/";
		
		given()
		.formParam("createdBy", "Ashwini")
		.formParam("projectName", "xylem")
		.formParam("status", "Created")
		.formParam("teamSize", 1)
		
		//Action
		.when()
		.post("addProject")
		
		//Validation
		.then().log().all();
	}

}
