package com.api.users.core;

import static io.restassured.RestAssured.given;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Rest {

	private static final String JSON_TYPE = "application/json";
	
	public static final Response getResource(final String url) {
		System.out.println("GetURL : "+url);
			return given().contentType(Rest.JSON_TYPE).when().get(url);
	}

	public static final Response postResource(final String url, final String jsonPayload) {
		System.out.println("Req Payload: "+url);
			return given().contentType(Rest.JSON_TYPE).body(jsonPayload).when().post(url);
	}

}
