$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/placeValidation.feature");
formatter.feature({
  "name": "Validate Place APIs",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify place deleted successfully using DeletePlaceAPI",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@DeletePlace"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Delete place Payload",
  "keyword": "Given "
});
formatter.match({
  "location": "placeValidationSteps.delete_place_Payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"DeletePlaceAPI\" called using \"POST\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "placeValidationSteps.called_using_http_request(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API call is success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "placeValidationSteps.api_call_is_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "placeValidationSteps.in_response_body_is(String,String)"
});
formatter.result({
  "status": "passed"
});
});