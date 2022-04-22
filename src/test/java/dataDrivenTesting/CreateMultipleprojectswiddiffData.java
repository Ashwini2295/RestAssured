package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonlibraries.JavaLibrary;
import io.restassured.http.ContentType;
import projectLibrary.Projectlibrary;

import static io.restassured.RestAssured.*;

public class CreateMultipleprojectswiddiffData 
{
	@Test(dataProvider = "getData" )
	public void createMultipleProjects(String createdBy,String projectName, String status,int teamSize)
	{
		//prerequisites
		JavaLibrary jlib = new JavaLibrary();
		Projectlibrary plib = new Projectlibrary(createdBy, projectName+jlib.getRandomNumber(), status, teamSize);
		
		baseURI="http://localhost:8084/";
		
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		.when()  //action
		.post("addProject")
		
		.then()  //validation
		.log().all();
	}
	
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data = new Object[2][4];
		
		data[0][0] = "Ashwini";
		data[0][1] = "TYSS";
		data[0][2] = "On-going";
		data[0][3] = 12;
		
		data[1][0] = "Dia";
		data[1][1] = "hp";
		data[1][2] = "completed";
		data[1][3] = 10;	
		return data;
	}

}
