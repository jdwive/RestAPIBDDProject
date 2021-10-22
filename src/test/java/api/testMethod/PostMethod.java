package api.testMethod;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethod {
	@Test
	public void ragistrationSuccessful() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.header("Content-Type", "application/JSON");
		
		httpRequest.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}");
		Response response = httpRequest.request(Method.POST,"/api/users");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
