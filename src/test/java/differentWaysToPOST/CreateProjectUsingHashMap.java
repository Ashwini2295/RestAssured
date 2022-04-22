package differentWaysToPOST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	@Test
	public void createprojectUsingHashmap()
	{
		JavaLibrary jlib = new JavaLibrary();
		baseURI="http://localhost:8084/";
		HashMap map = new HashMap();
		map.put("createdBy","Ashwini");
		map.put("projectName", "States "+jlib.getRandomNumber());
		map.put("stats", "Completed");
		map.put("teamSize", 12);
		
		
		
		given()
		.body(map)
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
