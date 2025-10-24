package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.util.TestDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify that a standard user can log in successfully")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver).open();
        TestDataLoader.Credentials credentials = TestDataLoader.getValidCredentials();
        InventoryPage inventoryPage = loginPage.loginAs(credentials.getUsername(), credentials.getPassword());
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page should be displayed after login");
    }
}
