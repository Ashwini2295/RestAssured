package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectLibrary.Projectlibrary;

public class CreateProjectAnddeleteProject 
{
	@Test
	public void ceateprojectandgetproject()
	{
		//step 1: create project using pojo
		JavaLibrary jlib = new JavaLibrary();
		Projectlibrary plib = new Projectlibrary("Avengers", "xyzzz"+jlib.getRandomNumber(), "Completed", 20);
		baseURI="http://localhost:8084/";
		
		Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		//Capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		given()
		.pathParam("pid", proId)
		.when()
		.delete("projects/{pid}")
		.then()
		.assertThat().statusCode(204).log().all();
		
	}

}
