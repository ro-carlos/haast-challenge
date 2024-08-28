package com.challenge.driver.factory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class extended by Drivers creators
 *
 * @author Carlos Rodríguez
 */
public abstract class WebDriverCreator {
	public abstract WebDriver createWebDriver() throws MalformedURLException;
}
