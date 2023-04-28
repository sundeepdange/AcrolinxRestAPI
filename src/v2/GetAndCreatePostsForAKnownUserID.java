package v2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAndCreatePostsForAKnownUserID {

	/* GET posts for a known User with API Version 2
	 * GET, POST v2/users/{id}/posts
	 */

	@Test
	public void getPostsOfKnownUserIDs() {
		RestAssured.baseURI = "https://gorest.co.in";
		String user_id = "1254400";
		given().log().all().when().get("public/v2/users/" + user_id + "/posts").then().assertThat().log().all()
				.statusCode(200);

		/* Create [POST] posts for a known User with API Version 2 */

		given().log().all().header("Content-Type", "application/json").and()
				.header("Authorization", "Bearer ff6b99b3e0726c04ae151bfdd2b2683801cde7d84bea0a75dcd5c0243bc472fe")
				.body("{\n" + "    \"user\": \"Test Name\",\n" + "    \"user_id\": " + user_id + ",\n"
						+ "    \"title\": \"sample text data\",\n"
						+ "    \"body\": \"This is a sample text data for creating a post for a known User\"\n" + "}")
				.when().post("public/v2/users/" + user_id + "/posts").then().assertThat().log().all().statusCode(201);
	}
}