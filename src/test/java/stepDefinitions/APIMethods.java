package stepDefinitions;

import org.testng.Assert;

import Utility.ExcelUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIMethods {
	public ExcelUtility utility;
	public RequestSpecification httpRequest;
	static Response response;
	static int testNum;
	static String expectedStatusCode;
	
	@Given("{string} EndPoint URL and URI has Given")
	public void end_point_url_and_uri_has_given(String string) throws Exception{
		String testCaseNum=string;
		
	testNum=Integer.valueOf(testCaseNum.replaceAll("[^0-9]", ""));
	utility= new ExcelUtility();
	String endPoint= utility.readExcel(testNum, 2);
	RestAssured.baseURI= endPoint;
    System.out.println(RestAssured.baseURI);
}

	@When("Request sent to server")
	public void request_sent_to_server() throws Exception{
		utility= new ExcelUtility();
	try {
		String method=utility.readExcel(testNum, 3);
		String uri = utility.readExcel(testNum, 4);
		String body = utility.readExcel(testNum, 5);
		System.out.println("method : "+method);
		System.out.println("Uri: "+uri);
		System.out.println("body: "+body);
		System.out.println(RestAssured.baseURI);
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/JSON");
	
		if (method.equalsIgnoreCase("GET")) {
			response = httpRequest.request(Method.GET,uri);
		
		}
		else if(method.equalsIgnoreCase("Post")) {
			httpRequest.body(body);
			response = httpRequest.request(Method.POST, uri);
			
		}
		else if(method.equalsIgnoreCase("PUT")) {
			httpRequest.body(body);
			response = httpRequest.request(Method.PUT, uri);
		}
		else if(method.equalsIgnoreCase("DELETE")) {
			response = httpRequest.request(Method.DELETE, uri);
		}
		}
	catch(Exception e) {
		System.out.println(e);
	}
   
   }

	@Then("Verify Received Response has matched with Expected Result")
	public void verify_received_response_has_matched_with_expected_result() throws Exception {
		utility= new ExcelUtility();
	String responseBody = response.getBody().asString();
	String statusCode = String.valueOf(response.getStatusCode());
	
	try {
	expectedStatusCode = utility.readExcel(testNum, 8);
	
	utility.writeExcel(testNum, 6, responseBody);
	utility.writeExcel(testNum, 7, statusCode);
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	Assert.assertEquals(statusCode, expectedStatusCode, "Expected status Code is "+ expectedStatusCode+ "but Actual statusCode is "+statusCode);
   
}


}
