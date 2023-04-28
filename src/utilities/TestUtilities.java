package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtilities {

	public static String randomAlphaNumericString() {
		String randomAlphaNum = RandomStringUtils.randomAlphanumeric(5);
		return randomAlphaNum;
	}

}
