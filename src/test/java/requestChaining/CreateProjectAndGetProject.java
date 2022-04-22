package requestChaining;

import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectLibrary.Projectlibrary;

public class CreateProjectAndGetProject 
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
		
		
		//create a get request and pass proid as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
	}

}
