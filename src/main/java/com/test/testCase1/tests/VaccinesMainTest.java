package com.test.testCase1.tests;

import com.test.testCase1.pages.VaccinesLoginPage;
import com.test.testCase1.pages.VaccinesMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VaccinesMainTest extends VaccinesTestBase{

    @Parameters({"username", "password", "home"})
    @Test(priority = 1)
    public void validateAccountCreation(String username, String password, String home) throws InterruptedException {
        VaccinesLoginPage vaccinesLoginPage = new VaccinesLoginPage(driver);
        vaccinesLoginPage.registerNewAccount(username, password);
        vaccinesLoginPage.loginIntoAccount(username, password);
        VaccinesMainPage vaccinesMainPage = new VaccinesMainPage(driver);
        vaccinesMainPage.validateAccountCreation(driver, home, username);
    }

    @Parameters({"username", "password", "category", "illness"})
    @Test(priority = 2)
    public void addToCart(String username, String password, String category, String illness) throws InterruptedException {
        VaccinesLoginPage vaccinesLoginPage = new VaccinesLoginPage(driver);
        vaccinesLoginPage.loginIntoAccount(username, password);
        VaccinesMainPage vaccinesMainPage = new VaccinesMainPage(driver);
        vaccinesMainPage.addItemsToCart(driver, category,illness);

    }


}
