package com.challenge.pages.login;

import com.challenge.pages.BasePage;
import com.challenge.pages.inventory.InventoryPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Login page
 *
 * @author Carlos Rodríguez
 */
public class LoginPage extends BasePage {

	@FindBy(css = ".login_logo")
	private WebElement loginLogo;

	@FindBy(id = "user-name")
	private WebElement usernameInput;

	@FindBy(id="password")
	private WebElement passwordInput;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorText;

	public LoginPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(loginLogo);
	}

	/**
	 * Enters username in input
	 * @param username {@link String}
	 */
	public void enterUsername(String username){
		getLogger().info("Entering username");
		getReportsLogger().log(LogStatus.INFO,"Entering username");
		getActions().enterText(usernameInput, username);
	}

	/**
	 * Enters password in input
	 * @param password {@link String}
	 */
	public void enterPassword(String  password){
		getLogger().info("Entering password");
		getReportsLogger().log(LogStatus.INFO,"Entering password");
		getActions().enterText(passwordInput, password);
	}

	/**
	 * Clicks on login button
	 *
	 * @return {@link InventoryPage}
	 */
	public <T extends BasePage> T clickOnLoginButton(){
		getActions().waitAndClick(loginButton);
		try {
			getActions().waitElementForVisibility(errorText);
			getLogger().info("Login failed, staying on LoginPage");
			getReportsLogger().log(LogStatus.INFO, "Login failed, staying on LoginPage");
			return (T) this;
		} catch (TimeoutException e) {
			getLogger().info("Login successful, navigating to HomePage");
			getReportsLogger().log(LogStatus.INFO, "Login successful, navigating to HomePage");
			return (T) new InventoryPage(getDriver(), getWait(), getReportsLogger());
		}
	}

	/**
	 * Checks if the login button is visible
	 *
	 * @return boolean indicating visibility of the login button
	 */
	public boolean isLoginButtonVisible() {
		getLogger().info("Checking if login button is visible");
		getReportsLogger().log(LogStatus.INFO, "Checking if login button is visible");
		return getActions().isElementPresent(loginButton);
	}

	/**
	 * Retrieves error text
	 *
	 * @return {@link String}
	 */
	public String getErrorText(){
		return errorText.getText();
	}
}
