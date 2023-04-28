package v2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetPostDeleteUserPosts {

	/* GET User posts with API Version 2 */

	@Test
	public void getPostDeleteUserPosts() {
		RestAssured.baseURI = "https://gorest.co.in";

		// GET User Posts
		String responseForGetRequest = given().log().all().when().get("public/v2/posts").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();
		// Parsing JSON
		JsonPath js1 = new JsonPath(responseForGetRequest);
		String userId = js1.getString("[0].user_id");

		// POST user Posts
		String responseForPostRequest = given().log().all().header("Content-Type", "application/json").and()
				.header("Authorization", "Bearer ff6b99b3e0726c04ae151bfdd2b2683801cde7d84bea0a75dcd5c0243bc472fe")
				.body("{\n" + "    \"user\": \"Test Name 2\",\n" + "    \"user_id\": " + userId + ",\n"
						+ "    \"title\": \"sample text data 280401\",\n"
						+ "    \"body\": \"This is a sample text data for creating a post for a known User\"\n" + "}")
				.when().post("public/v2/posts").then().assertThat().log().all().statusCode(201).extract().response()
				.asString();
		// Parsing JSON
		JsonPath js2 = new JsonPath(responseForPostRequest);
		String postId = js2.getString("id");

		// Delete user posts
		given().log().all()
				.header("Authorization", "Bearer ff6b99b3e0726c04ae151bfdd2b2683801cde7d84bea0a75dcd5c0243bc472fe")
				.delete("public/v2/posts/" + postId + "").then().assertThat().log().all().statusCode(204);

	}

}
