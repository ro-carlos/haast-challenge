package com.challenge.pages.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Main page of app
 *
 * @author Carlos Rodríguez
 */
public class InventoryPage extends BasePage {

	@FindBy(css = ".inventory_item_img")
	private List<WebElement> productsImages;

	@FindBy(css="[data-test='title']")
	private WebElement title;

	@FindBy(css = "[data-test='inventory-item']")
	private List<WebElement> productsList;

	@FindBy(css = "[data-test='shopping-cart-link']")
	private WebElement shoppingCart;

	private By productNameLocator = By.cssSelector("[data-test*='title-link']");
	private By addItemToCartLocator = By.cssSelector("button[id*='add-to-cart']");
	private By removeItemFromCartLocator = By.cssSelector("button[id*='remove'");

	public InventoryPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(productsImages.get(0));
	}

	/**
	 * Retrieves page title text
	 *
	 * @return {@link String}
	 */
	public String getTitle(){
		getLogger().info("Returning invetory page title");
		getReportsLogger().log(LogStatus.INFO,"Returning inventory page title");
		return getActions().getText(title);
	}

	/**
	 * Returns a list of product names
	 *
	 * @return List of Strings representing product names
	 */
	public List<String> getProductsList() {
		getLogger().info("Retrieving product list");
		getReportsLogger().log(LogStatus.INFO,"Retrieving product list");
		return productsList.stream()
				.map(element -> getActions()
				.getText(element.findElement(productNameLocator))
				).collect(Collectors.toList());

	}

	/**
	 * Checks if the product list is visible
	 *
	 * @return boolean indicating visibility of the product list
	 */
	public boolean isProductListVisible() {
		getLogger().info("Checking product list is visible");
		getReportsLogger().log(LogStatus.INFO,"Checking product list is visible");
		return !productsList.isEmpty() && getActions().isElementPresent(productsList.get(0));
	}

	/**
	 * Checks if the product list is visible
	 * @param productName Name of the product to add to the cart
	 *
	 * @return boolean indicating visibility of the product list
	 */
	public boolean isProductVisible(String productName) {
		getLogger().info(String.format("Checking if product [%s] is visible", productName));
		getReportsLogger().log(LogStatus.INFO,String.format("Checking if product [%s] is visible", productName));
		return findProductByName(productName) != null;
	}

	/**
	 * Adds a product to the cart by product name
	 * @param productName Name of the product to add to the cart
	 */
	public void addProductToCartByName(String productName) {
		getLogger().info("Adding product from shopping cart");
		getReportsLogger().log(LogStatus.INFO,"Adding product from shopping cart");
		WebElement addToCartButton = findProductCardByName(productName).findElement(addItemToCartLocator);
		addToCartButton.click();
		getLogger().info("Added product to cart: " + productName);
		getReportsLogger().log(LogStatus.INFO, "Added product to cart: " + productName);
	}

	/**
	 * Removes a product from the cart by product name
	 * @param productName Name of the product to remove from the cart
	 */
	public void removeProductFromCartByName(String productName) {
		getLogger().info("Removing product from shopping cart");
		getReportsLogger().log(LogStatus.INFO,"Removing product from shopping cart");
		WebElement removeFromCartButton = findProductCardByName(productName).findElement(removeItemFromCartLocator);
		removeFromCartButton.click();
		getLogger().info("Removed product from cart: " + productName);
		getReportsLogger().log(LogStatus.INFO, "Removed product from cart: " + productName);

	}

	/**
	 * Retrieves shopping cart link text
	 *
	 * @return {@link String}
	 */
	public String getShoppingCart(){
		getLogger().info("Returning shopping cart link");
		getReportsLogger().log(LogStatus.INFO,"Returning shopping cart link");
		return getActions().getText(shoppingCart);
	}


	/**
	 * Finds a product card element by its name
	 * @param productName Name of the product to find
	 * @return {@link WebElement} representing the product, or null if not found
	 */
	private WebElement findProductCardByName(String productName) {
		WebElement cartItemToRemove = findProductByName(productName);
		if (cartItemToRemove != null) {
			getLogger().info("Removed product from cart: " + productName);
			getReportsLogger().log(LogStatus.INFO, "Removed product from cart: " + productName);
			return cartItemToRemove;
		} else {
			throw new IllegalArgumentException("Cart item not found: " + productName);
		}
	}

	/**
	 * Finds a product element by its name
	 * @param productName Name of the product to find
	 * @return {@link WebElement} representing the product, or null if not found
	 */
	private WebElement findProductByName(String productName) {
		getLogger().info("Finding product in products list");
		getReportsLogger().log(LogStatus.INFO,"Finding product in products list");
		for (WebElement product : productsList) {
			String currentProductName = getActions().getText(product.findElement(productNameLocator));
			if (currentProductName.contains(productName)) {
				return product;
			}
		}
		return null;
	}
}
