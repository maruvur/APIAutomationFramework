
Feature: Validate Place APIs
@AddPlace @Regression
Scenario Outline: Verify place added successfully using AddPlaceAPI

    Given Add place Payload with "<name>" "<language>" "<address>"
    When "AddPlaceAPI" called using "POST" http request
    Then API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_id created with "<name>" in "GetPlaceAPI"
     
Examples:
	|name	|language	|address	|
	|AAhouse	|Tamil	|Nallurahalli	|
  |Madurai	|English	|Theppakulam	|

@DeletePlace @Regression
Scenario: Verify place deleted successfully using DeletePlaceAPI

	  Given Delete place Payload
    When "DeletePlaceAPI" called using "POST" http request
    Then API call is success with status code 200
    And "status" in response body is "OK"
