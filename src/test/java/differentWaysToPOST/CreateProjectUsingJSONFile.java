package differentWaysToPOST;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile {
	@Test
	public void createprojectusingjsonfile()
	{
		baseURI="http://localhost:8084/";
		File file = new File(".\\Data.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}

}
