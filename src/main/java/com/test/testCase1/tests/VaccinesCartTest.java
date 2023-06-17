package com.test.testCase1.tests;

import com.test.testCase1.pages.VaccinesCartPage;
import com.test.testCase1.pages.VaccinesLoginPage;
import com.test.testCase1.pages.VaccinesMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VaccinesCartTest extends VaccinesTestBase{

    @Parameters({"username", "password", "expectedItem1", "expectedItem2"})
    @Test
    public void validateItemsInCart(String username, String password, String expectedItem1, String expectedItem2) throws InterruptedException {
        VaccinesLoginPage vaccinesLoginPage = new VaccinesLoginPage(driver);
        vaccinesLoginPage.loginIntoAccount(username, password);
        VaccinesMainPage vaccinesMainPage = new VaccinesMainPage(driver);
        vaccinesMainPage.clickCartButton();
        VaccinesCartPage vaccinesCartPage = new VaccinesCartPage(driver);
        vaccinesCartPage.validateItemsInCart(expectedItem1, expectedItem2);
    }
}
