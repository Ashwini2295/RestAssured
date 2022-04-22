package crudoperationwidBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetOneProject {
	@Test
	public void getAllProjects()
	{
		baseURI = "http://localhost:8084/";
		when()
		.get("projects/TY_PROJ_402")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

	}

}
