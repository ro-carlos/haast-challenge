package com.challenge.tests.ui.logout;

import com.challenge.dataprovider.UsersDataProvider;
import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.inventory.InventoryPage;
import com.challenge.pages.login.LoginPage;
import com.challenge.pages.navBar.NavbarPage;
import com.challenge.tests.BaseTest;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * Test class containing login page scenarios
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.WEB)
public class LogoutTest extends BaseTest {

	@Test (dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"regression"})
	public void loginWithValidUser(String username, String password){
		// Step 1: Login and navigate to InventoryPage using the helper method
		LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		final InventoryPage inventoryPage = loginPage.clickOnLoginButton();

		// Step 2: Assert that the user is on the InventoryPage
		assertTrue(inventoryPage.getTitle().contains("Products"), "Products section is present");
		assertFalse(inventoryPage.getProductsList().isEmpty(), "There are products available");
		assertTrue(inventoryPage.isProductListVisible(), "There are products visible");

		// Step 3: Logout user and navigate to LoginPage opening hamburger menu
		NavbarPage navbarPage = inventoryPage.getNavbar();
		navbarPage.openHamburgerMenu();

		// Step 4: Assert that the user is on the LoginPage
		loginPage = navbarPage.logoutUser();
		assertTrue(loginPage.isLoginButtonVisible(), "Login button is present");
	}
}
