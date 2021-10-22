package api.testMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	@Test
	public void updateUser() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		
		String body="{\r\n"
				+ "    \"name\": \"Sonu\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		httpRequest.header("Content-Type", "application/JSON");
		httpRequest.body(body);
		Response response=httpRequest.request(Method.PUT,"/api/users/2");
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}

}
