package com.rmg.parametertest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetoneProjectUsinPathParam 
{
	@Test
	public void getRepoTest()
	{
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999");
		when()
		 .get("https://api.github.com/user/repos")
		 .then()
		 .log().all();
	}

}
