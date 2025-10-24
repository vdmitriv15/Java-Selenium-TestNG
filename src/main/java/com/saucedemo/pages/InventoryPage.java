package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(productsTitle, "Products"));
    }
}
