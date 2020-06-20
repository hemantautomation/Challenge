package com.cldcvr.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiTest {

	@Before
	public void init() {
		RestAssured.baseURI = "http://35.188.114.237:8088";
	}

	@Test
	public void challenge0() {

		Response response = RestAssured.given().when().get("api/v2/users").then().contentType(ContentType.JSON)
				.extract().response();
		List<Integer> object = response.jsonPath().getList("user.id");
		for (Integer in : object) {
			System.out.println(in);
		}

		Assert.assertTrue(response.statusCode() == 200);

	}

	@Test
	public void challenge1() {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "adaasdsm");
		map.put("surname", "Sindasdsaler");
		map.put("adress", "swarg");
		
		Response response =	RestAssured.given()
        .contentType(ContentType.JSON)
        .body("{\n" + 
        		"\"name\":\" Adam\",\n" + 
        		"\"surname\":\"Sindler\",\n" + 
        		"\"adress\":\"Boston\"\n" + 
        		"}'")
        .put("/api/v2/updateuser")
        .then().contentType(ContentType.JSON)
		.extract().response();
        ;
					
		System.out.println(response.getBody().asString());

	}

}
