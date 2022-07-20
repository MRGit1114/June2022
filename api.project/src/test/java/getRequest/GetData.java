package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetData {

	String api="https://reqres.in/";
	
	@Test
	public void verifyEmailAddress() {
		String email = "janet.weaver@reqres.in";
		//Response response = httpRequest.get("https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/");
	}
	
	@Test
	public void getResponseCodeAndVerifyIfSuccessful() {
		
		int code = get(api).getStatusCode();
		System.out.println("Code: "+code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void getResponseTimeofAPI() {
		Long time=get(api).getTime();
		System.out.println("Response Time: "+time);
	}
}
