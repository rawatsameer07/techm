package com.api.users.stepDefs;


import java.util.List;

import com.api.users.core.HelperUtils;
import java.util.Optional;  
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.CreateUsersRequest;
import pojo.CreateUsersResponse;

public class StepDefJson {

	public static CreateUsersRequest createUsers;
	public static CreateUsersResponse createUsersResp;
	public static String userJsonReqPayload;
	public static ObjectMapper objectMapper;
	
	/***** Provide input parameters to request 
	 * @throws JsonProcessingException *****/
    @When("^I create user with name \"([^\"]*)\" and job as \"([^\"]*)\"$")
    public static void configureJSON(String name, String job) throws JsonProcessingException {
    	createUsers = new CreateUsersRequest().setName(name).setJob(job);
    	objectMapper = new ObjectMapper();
    	userJsonReqPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createUsers);
		System.out.println(userJsonReqPayload);
       }
    
    /***** Save a value from the response 
     * @throws JsonProcessingException 
     * @throws JsonMappingException *****/
    @Then("^I save value \"([^\"]*)\"$")
    public static void saveElement(String value) throws JsonMappingException, JsonProcessingException {
        String objResult = readValueFromJSON(StepDefCore.response.getBody().asString(), value.split("-->")[0]);
        if (objResult == null) {
            value = value.replace(value.split("-->")[0], "");
        } else {
            value = value.replace(value.split("-->")[0], objResult);
        }
        HelperUtils.analyzeValue(value);

    }
    
    
    public static Optional<String> value ;
    public static String readValueFromJSON(String response, String parameterName) throws JsonMappingException, JsonProcessingException {	
    	
		ObjectMapper objectMapper = new ObjectMapper();
		createUsersResp = objectMapper.readValue(response, CreateUsersResponse.class);
		value = createUsersResp.getValue(createUsersResp,parameterName);
		System.out.println(value);
		return String.valueOf(value.get());
	}
}
