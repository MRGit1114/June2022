package getRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetData {

	@Test
	public void getSingleUserEmailAddress() {

		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.body("data.email", equalTo("janet.weaver@reqres.in"));

	}

	@Test
	public void verifyPOSTToken() {

		given()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
	}

	@Test
	public void verifyResponseCode() {
		
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204);
	}

	@Test
	public void lookupResponseCode() {

		given()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log()
		.all();
	}

	@Test
	public void writePatch() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus2");
		map.put("job", "leader");
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(map)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();

	}

	@Test
	public void writePut() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus2");
		map.put("job", "leader");
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(map)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log()
		.all();


	}
	@Test
	public void getSingleUser() {

		RequestSpecification request = RestAssured.given();
        	request.baseUri("https://reqres.in/ ");
        	request.basePath("/api/users/2");
        	Response response = request.get();
        	JSONResponse responseBody = response.getBody().as(JSONResponse.class);
        
        	Assert.assertEquals("janet.weaver@reqres.in", responseBody.data);
	}

	@Test
	public void getListUsers() {

		RequestSpecification request = RestAssured.given();
        	request.baseUri("https://reqres.in/ ");
        	request.basePath("/api/users?page=2");
        	Response response = request.get();
        	JSONListResponse responseBody = response.getBody().as(JSONListResponse.class);
        	List<JSONData> dataObject = responseBody.data; 
		
        	Assert.assertEquals("emma.wong@reqres.in", dataObject.get(2).email);
	}
}
