package com.challenge.pages.navBar;

import com.challenge.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Main page of app
 *
 * @author Carlos Rodríguez
 */
public class NavbarPage extends BasePage {

    @FindBy(css = "[data-test='header-container'] .bm-burger-button button")
    private WebElement hamburgerMenuButton;

    @FindBy(css = "[data-test='logout-sidebar-link']")
    private WebElement logoutLink;

    public NavbarPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
        super(driver, wait, reportsLogger);
    }

    @Override
    protected void pageLoadedElement() {
        getActions().waitElementForVisibility(hamburgerMenuButton);
    }

    /**
     * Opens hamburger menu
     */
    public void openHamburgerMenu() {
        getLogger().info("Opening hamburger menu");
        getReportsLogger().log(LogStatus.INFO, "Opening hamburger menu");
        getActions().waitAndClick(hamburgerMenuButton);
    }

    /**
     * Redirects user to login page
     * @return {@link LoginPage}
     */
    public LoginPage logoutUser(){
        getLogger().info("Logging out user");
        getReportsLogger().log(LogStatus.INFO, "Logging out user");
        getActions().waitAndClick(logoutLink);
        return new LoginPage(getDriver(), getWait(), getReportsLogger());
    }

}
