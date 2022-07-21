package getRequest;

import java.util.HashMap;
import java.util.Map;
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

		given().get("https://reqres.in/api/users/2").then().body("data.email", equalTo("janet.weaver@reqres.in"));

	}

	@Test
	public void verifyPOSTToken() {

		given().post("https://reqres.in/api/users").then().statusCode(201);
	}

	@Test
	public void verifyResponseCode() {
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204);
	}

	@Test
	public void lookupResponseCode() {

		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
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

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/api/users/2");
		System.out.println("Response Body is: " + response.asString());
	}

	@Test
	public void getListUsers() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users?page=2");
		System.out.println("Response Body is: " + response.asString());
	}
}
