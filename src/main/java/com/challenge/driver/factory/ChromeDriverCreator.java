package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.challenge.utils.PropertiesReader;

/**
 * Chrome driver creator class
 *
 * @author Carlos Rodríguez
 */
public class ChromeDriverCreator extends WebDriverCreator {
	@Override
	public WebDriver createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation","load-extension"});
		options.addArguments("--remote-allow-origins=*"); //https://github.com/SeleniumHQ/selenium/issues/11750 related issue

		// Check for headless mode
		if (Boolean.getBoolean("headless")) {
			options.addArguments("--headless");
			options.addArguments("--disable-gpu"); // Required for headless mode on Windows
			options.addArguments("--window-size=1920,1080");
		}

		return new ChromeDriver(options);
	}

}
