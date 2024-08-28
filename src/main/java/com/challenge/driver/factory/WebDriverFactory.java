package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;

import com.challenge.utils.Browser;

/**
 * Factory class to create different types of sessions given browser
 *
 * @author Carlos Rodríguez
 */
public class WebDriverFactory {

	public static WebDriver getDriver(Browser browser) throws Exception{
		switch (browser) {
			case FIREFOX:
				FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
				return firefoxDriverCreator.createWebDriver();
			case CHROME:
				ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
				return chromeDriverCreator.createWebDriver();
			default:
				throw new Exception("Not supported Browser");
		}
	}
}
