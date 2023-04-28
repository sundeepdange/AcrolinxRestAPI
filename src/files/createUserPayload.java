package files;

import utilities.TestUtilities;

public class createUserPayload {

	public static String AddUser() {
		String userName = TestUtilities.randomAlphaNumericString();
		return "{\n" + "    \"name\": \"" + userName + "\",\n" + "    \"email\": \"" + userName
				+ "@test.com\",\n" + "    \"gender\": \"male\",\n" + "    \"status\": \"active\"\n" + "}";
	}
}
