package com.challenge.tests.ui.login;

import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.inventory.InventoryPage;
import com.challenge.pages.login.LoginPage;
import org.testng.annotations.Test;

import com.challenge.tests.BaseTest;
import com.challenge.dataprovider.UsersDataProvider;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;

import static org.testng.Assert.*;


/**
 * Test class containing login page scenarios
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.WEB)
public class LoginTest extends BaseTest {

	@Test (dataProvider = "validUserWrongPasswordDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"regression"})
	public void loginWithValidUserWrongPassword(String username, String password){
		final LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

		assertTrue(loginPage.getErrorText()
				.contains("Username and password do not match any user in this service"),
				"User added incorrect credentials");
	}

	@Test (dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"smoke"})
	public void loginWithValidUser(String username, String password){
		final LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		final InventoryPage inventoryPage = loginPage.clickOnLoginButton();

		assertTrue(inventoryPage.getTitle().contains("Products"), "Products section is present");
		assertFalse(inventoryPage.getProductsList().isEmpty(), "There are products available");
		assertTrue(inventoryPage.isProductListVisible(), "There are products visible");
	}
}
