package com.challenge.tests.ui.cart;

import com.challenge.dataprovider.UsersDataProvider;
import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.inventory.InventoryPage;
import com.challenge.pages.login.LoginPage;
import com.challenge.tests.BaseTest;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * Test class containing login page scenarios
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.WEB)
public class CartTest extends BaseTest {

	@Test(dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"smoke", "regression"})
	public void addItemToCart(String username, String password) {
		// Step 1: Login and navigate to InventoryPage using the helper method
		InventoryPage inventoryPage = loginAndNavigateToInventory(username, password);

		// Step 2: Assert that the user is on the InventoryPage
		assertTrue(inventoryPage.isProductListVisible(), "The product list is not visible on the InventoryPage.");

		// Step 3: Add item to cart by name and verify
		String productName = "Sauce Labs Fleece Jacket";
		inventoryPage.addProductToCartByName(productName);
		assertEquals(inventoryPage.getShoppingCart(), "1", "Cart should contain 1 item after adding a product.");
	}

	@Test(dataProvider = "validUserDataProvider", dataProviderClass = UsersDataProvider.class, groups = {"smoke", "regression"})
	public void removeItemFromCart(String username, String password) {
		// Step 1: Login and navigate to InventoryPage using the helper method
		InventoryPage inventoryPage = loginAndNavigateToInventory(username, password);

		// Step 2: Assert that the user is on the InventoryPage
		assertTrue(inventoryPage.isProductListVisible(), "The product list is not visible on the InventoryPage.");

		// Step 3: Add item to cart by name and verify
		String productName = "Sauce Labs Fleece Jacket";
		inventoryPage.addProductToCartByName(productName);
		assertEquals(inventoryPage.getShoppingCart(), "1", "Cart should contain 1 item after adding a product.");

		// Step 4: Remove item from cart by name and verify
		inventoryPage.removeProductFromCartByName(productName);
		assertEquals(inventoryPage.getShoppingCart(), "", "Cart should be empty after removing the product.");
	}

	private InventoryPage loginAndNavigateToInventory(String username, String password) {
		final LoginPage loginPage = new LoginPage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		return loginPage.clickOnLoginButton(); // Returns InventoryPage instance after login
	}

}
