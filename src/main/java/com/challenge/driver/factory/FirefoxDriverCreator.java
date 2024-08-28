package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Firefox driver creator class
 *
 * @author Carlos Rodríguez
 */
public class FirefoxDriverCreator extends WebDriverCreator{
	@Override
	public WebDriver createWebDriver() {
		return new FirefoxDriver();
	}

}
