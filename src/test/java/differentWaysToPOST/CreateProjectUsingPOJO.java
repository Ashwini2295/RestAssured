package differentWaysToPOST;

import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.Projectlibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO 
{
	@Test
	public void createproject()
	{
		JavaLibrary jlib = new JavaLibrary();
		baseURI="http://localhost:8084/";
		
		Projectlibrary plib = new Projectlibrary("Ashhhh", "xyzzz"+jlib.getRandomNumber(), "Complete", 10);
		given()
		.body(plib)
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
