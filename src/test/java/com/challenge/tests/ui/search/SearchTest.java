package com.challenge.tests.ui.search;

import com.challenge.dataprovider.UsersDataProvider;
import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.inventory.InventoryPage;
import com.challenge.pages.login.LoginPage;
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
public class SearchTest extends BaseTest {

	@Test(dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"smoke"})
	public void searchExistingItemInCards(String username, String password) {
		// Step 1: Login and navigate to InventoryPage using the helper method
		final LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		InventoryPage inventoryPage =  loginPage.clickOnLoginButton();

		// Step 2: Assert that the user is on the InventoryPage
		assertTrue(inventoryPage.isProductListVisible(), "The product list is visible on the InventoryPage.");

		// Step 3: Search item in list by name and verify
		String productName = "Sauce Labs Fleece Jacket";
		assertTrue(inventoryPage.isProductVisible(productName), "The product is  visible on the InventoryPage.");
	}

	@Test(dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"smoke"})
	public void searchNonExistingItemInCards(String username, String password) {
		// Step 1: Login and navigate to InventoryPage using the helper method
		final LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		InventoryPage inventoryPage =  loginPage.clickOnLoginButton();

		// Step 2: Assert that the user is on the InventoryPage
		assertTrue(inventoryPage.isProductListVisible(), "The product list is visible on the InventoryPage.");

		// Step 3: Search item in list by name and verify
		String productName = "Non Existing item";
		assertFalse(inventoryPage.isProductVisible(productName), "The product is not visible on the InventoryPage.");
	}
}
