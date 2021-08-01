package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utilities;

import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class placeValidationSteps extends Utilities {
	RequestSpecification finalReq;
	RequestSpecification baseDetailsReq;
	ResponseSpecification baseDetailsRes;
	Response response;
	TestDataBuild testData= new TestDataBuild();
	APIResources apiResource ;
	static String place_id;
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_Payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 
		   finalReq=given().spec(RequestSpecificationDetails()).body(testData.addPlacePayload(name,language,address));
		   
		   	
	}

	@When("{string} called using {string} http request")
	public void called_using_http_request(String resource, String method){
	    // Write code here that turns the phrase above into concrete actions
		APIResources apiResource =APIResources.valueOf(resource);
		baseDetailsRes= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		System.out.println(apiResource.getResource());
		if (method.equalsIgnoreCase("POST"))
		{
			 response=finalReq.when().post(apiResource.getResource())
					 .then().spec(baseDetailsRes)
		       		   .extract().response();
		}
		else if (method.equalsIgnoreCase("GET"))
		{
			 response=finalReq.when().get(apiResource.getResource())
					 .then().spec(baseDetailsRes)
		       		   .extract().response();
		}
	   
	               //.then().spec(baseDetailsRes)
	       		   //.extract().response();
	}

	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(), 200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	     
	    assertEquals(getJsonValue(response, keyvalue), expectedValue);
	    
	}
	
	@And("Verify place_id created with {string} in {string}")
	public void verify_place_id_created_with_in(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id=getJsonValue(response, "place_id");
		 finalReq=given().spec(RequestSpecificationDetails()).queryParam("place_id",place_id);
		 called_using_http_request(resource,"GET");
		 assertEquals(getJsonValue(response, "name").toString(),expectedName);
	} 
	@Given("Delete place Payload")
	public void delete_place_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 finalReq=given().spec(RequestSpecificationDetails()).body(testData.deletePayload(place_id));
	    
	}


}
