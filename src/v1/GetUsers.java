package v1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetUsers {

	/* GET Users with API Version 1 */

	@Test
	public void getUsers() {
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all().when().get("public/v1/users").then().assertThat().log().all().statusCode(200);
	}
}
