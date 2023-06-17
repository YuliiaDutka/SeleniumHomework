package com.test.testCase1.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class VaccinesMainPage {

    public VaccinesMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/profile']")
    WebElement profileButton;

    @FindBy(xpath = "//p[1]")
    List<WebElement> productDescriptions;

    @FindBy(tagName = "h5")
    List<WebElement> productTitles;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    List<WebElement> addToCart;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void validateAccountCreation(WebDriver driver, String home, String username) throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertTrue(driver.getCurrentUrl().contains(home));
        Assert.assertEquals(BrowserUtils.getText(profileButton), username);
    }

    public void addItemsToCart(WebDriver driver, String category, String illnessName) throws InterruptedException {
        for(int i = 0; i < productTitles.size(); i++){
            if(BrowserUtils.getText(productTitles.get(i)).toLowerCase().contains(category)
                    && BrowserUtils.getText(productDescriptions.get(i)).toLowerCase().contains(illnessName)){
                BrowserUtils.clickWithJS(driver, addToCart.get(i+1));
            }
        }
        Thread.sleep(1000);
    }

    public void clickCartButton() throws InterruptedException {
        cartButton.click();
        Thread.sleep(1000);
    }
}
