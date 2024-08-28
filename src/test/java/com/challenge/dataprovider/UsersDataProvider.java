package com.challenge.dataprovider;

import org.testng.annotations.DataProvider;


/**
 * Data provider class for test
 *
 * @author Carlos Rodríguez
 */
public class UsersDataProvider {

	@DataProvider (name = "validUserWrongPasswordDataProvider", parallel = true)
	public static Object[][] validUserWrongPasswordDataProvider() {
		return new Object [][] {
				{ "standard_user", "wrongPassword" },
		};
	}

	@DataProvider (name = "validUserDataProvider", parallel = true)
	public static Object[][] validUserDataProvider() {
		return new Object [][] {
				{ "standard_user", "secret_sauce" },
		};
	}
}
