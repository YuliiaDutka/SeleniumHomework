package com.test.testCase1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class VaccinesCartPage {

    public VaccinesCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> itemsTitlesInCart;

    public void validateItemsInCart(String expectedItem1, String expectedItem2){
        List<String> expectedItems = Arrays.asList(expectedItem1, expectedItem2);
        for(int i = 0; i < itemsTitlesInCart.size(); i++) {
            if(BrowserUtils.getText(itemsTitlesInCart.get(i)).equals(expectedItems.get(i))) {
                Assert.assertEquals(BrowserUtils.getText(itemsTitlesInCart.get(i)), expectedItems.get(i));
            }
        }
    }
}
