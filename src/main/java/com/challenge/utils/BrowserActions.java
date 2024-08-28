package com.challenge.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Browser actions is a class to perform actions on
 * {@link WebElement} using {@link WebDriverWait}
 *
 * @author Carlos Rodriguez
 *
 */
public class BrowserActions {

	private final WebDriver driver;
	private final WebDriverWait wait;

	private final Actions actions;
	private static final Logger logger = LogManager.getLogger();

	public BrowserActions(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(this.driver);
	}

	/**
	 * Waits until page is loaded by checking page state using javascript
	 *
	 */
	public void waitPageLoaded(){
		getWait().until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(
				"complete"));
	}

	/**
	 * Waits until web element is visible
	 * @param element {@link WebElement}
	 *
	 * @return {@link WebElement} retrieves web element
	 */
	public WebElement waitElementForVisibility(WebElement element){
		return getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits until locator is visible
	 * @param locator {@link By}
	 *
	 * @return {@link WebElement} retrieves web element
	 */
	public WebElement waitLocatorForVisibility(By locator){
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getDriver().findElement(locator);
	}

	/**
	 * Checks element visibility
	 * @param element {@link WebElement}
	 *
	 * @return {@code true} if locator is present, {@code false} otherwise
	 */
	public boolean isElementPresent(WebElement element){
		try {
			return waitElementForVisibility(element).isDisplayed();
		}catch (TimeoutException e){
			getLogger().info("Element not present: " + element);
		}
		return false;
	}

	/**
	 * Checks locator visibility
	 * @param locator {@link By}
	 *
	 * @return {@code true} if locator is present, {@code false} otherwise
	 */
	public boolean isLocatorPresent(By locator){
		try {
			return waitLocatorForVisibility(locator).isDisplayed();
		}catch (TimeoutException e){
			getLogger().info("Element not present: " + locator);
		}
		return false;
	}

	/**
	 * Retrieves text in web element
	 * @param element {@link WebElement}
	 *
	 * @return {@link String} retrieves web element text
	 */
	public String getText(WebElement element){
		return waitElementForVisibility(element).getText();
	}

	/**
	 * Enters text in web element
	 * @param element {@link WebElement}
	 * @param text {@link CharSequence}
	 *
	 */
	public void enterText(WebElement element, CharSequence text){
		waitElementForVisibility(element).sendKeys(text);
	}

	/**
	 * Waits for locator visibility and then clicks it
	 * @param locator {@link By}
	 *
	 */
	public void waitAndClick(By locator){
		waitAndClick(waitLocatorForVisibility(locator));
	}

	/**
	 * Clicks on a web element
	 * @param element {@link WebElement}
	 *
	 */
	public void waitAndClick(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	/**
	 * Waits until locator is present and then hovers on it
	 * @param locator {@link By}
	 *
	 */
	public void hoverElement(By locator){
		hoverElement(waitLocatorForVisibility(locator));
	}

	/**
	 * Performs hover on a web element
	 * @param element {@link WebElement}
	 *
	 */
	public void hoverElement(WebElement element){
		getActions().moveToElement(element).perform();
	}

	protected WebDriver getDriver(){
		return driver;
	}

	protected WebDriverWait getWait(){
		return wait;
	}

	protected Actions getActions(){
		return actions;
	}

	protected Logger getLogger(){
		return logger;
	}

}
