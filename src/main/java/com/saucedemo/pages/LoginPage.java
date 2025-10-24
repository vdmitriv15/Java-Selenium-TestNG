package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        return this;
    }

    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public InventoryPage submitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new InventoryPage(driver);
    }

    public InventoryPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return submitLogin();
    }
}
