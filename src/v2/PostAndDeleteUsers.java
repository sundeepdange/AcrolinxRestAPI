package v2;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import files.createUserPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostAndDeleteUsers {

	/*
	 * Create [POST] User with API Version 2 AND Delete [DELETE] the Created User
	 * POST and DELETE v2/Users
	 */

	@Test
	public void getPostAndDeleteUsers() {
		RestAssured.baseURI = "https://gorest.co.in";
		// GET Users
		given().log().all().when().get("public/v2/users").then().assertThat().log().all().statusCode(200);

		// Create [POST] User with API Version 2
		String response = given().log().all().header("Content-Type", "application/json").and()
				.header("Authorization", "Bearer ff6b99b3e0726c04ae151bfdd2b2683801cde7d84bea0a75dcd5c0243bc472fe")
				.body(createUserPayload.AddUser()).when().post("public/v2/users").then().assertThat().log().all()
				.statusCode(201).extract().response().asString();
		// Parsing JSON
		JsonPath js = new JsonPath(response);
		String id = js.getString("id");
		assertNotNull(id, "User id is not created");

		// delete the User created
		given().log().all()
				.header("Authorization", "Bearer ff6b99b3e0726c04ae151bfdd2b2683801cde7d84bea0a75dcd5c0243bc472fe")
				.delete("public/v2/users/" + id + "").then().assertThat().log().all().statusCode(204);

	}

}
