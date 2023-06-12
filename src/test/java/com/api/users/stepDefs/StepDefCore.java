package com.api.users.stepDefs;

import java.io.IOException;

import com.api.users.core.HelperUtils;
import com.api.users.core.Rest;
import com.jayway.jsonpath.ReadContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StepDefCore {
	public static ReadContext resJsonContext;
	public static Response response;
	public static String url;


	/***** SETTING A END POINT*****/
	@Given("^I set endpoint as \"([^\"]*)\" with API \"([^\"]*)\"$")
	public static void setEndpoint(String hostPort, String api) {
		System.out.println("Test: "+hostPort+" "+api);
		hostPort = HelperUtils.analyzeValue(hostPort);
		api = HelperUtils.analyzeValue(api);
		url = hostPort + api;
		System.out.println("URL is --> " + url);
	}
	
	@Given("^I set endpoint as \"([^\"]*)\" with API \"([^\"]*)\" along with \"([^\"]*)\"$")
	public void setEndpointAppID(String hostPort, String api, String path2) throws Exception, IOException {
		hostPort = HelperUtils.analyzeValue(hostPort);
		api = HelperUtils.analyzeValue(api);
		path2 = HelperUtils.analyzeValue(path2);
		url = hostPort + api + path2;
		System.out.println("URL is --> " + url);
	}
	
	/***** PRINT REQUEST *****/
	@Then("^I print request$")
	public void printFullRequest() {
		System.out.println("REQUEST: " + StepDefJson.userJsonReqPayload);
		}
	
	/***** INVOKING A POST API *****/
	@When("^I invoke the POST API with json payload$")
	public static void invokePostAPIWithPayload() {
		response = Rest.postResource(url, StepDefJson.userJsonReqPayload);
		//resJsonContext = JsonPath.parse(response.getBody().asString());
	}
	
	/***** INVOKING A GET API *****/
	@When("^I invoke the GET API$")
	public void invokeAPI() {
		response = Rest.getResource(url);
		
	}
	
	/***** PRINT RESPONSE *****/
	@Then("^I print response$")
	public void printFullResponse() {
		System.out.println("RESPONSE: " + response.getBody().asString());
	}

}
