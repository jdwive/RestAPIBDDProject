package api.testMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	@Test
	public void getWeatherDetails() {
		RestAssured.baseURI="http://demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Contenct-Type", "application/Json");
		Response response = httprequest.request(Method.GET, "/PUNE");
		
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	

}
