package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;


public class Hooks {
	
	@Before("@DeletePlace")
	public void preConditions() throws IOException {
		//execute when place_id is null
		System.out.println("Hooks");
		placeValidationSteps validateSteps=new placeValidationSteps();
		if(placeValidationSteps.place_id==null)
		{
		validateSteps.add_place_Payload_with("Aarthi", "Tamil", "India");
		validateSteps.called_using_http_request("AddPlaceAPI", "POST");
		validateSteps.verify_place_id_created_with_in("Aarthi", "GetPlaceAPI");
		}
		
	}

}
