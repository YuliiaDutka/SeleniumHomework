package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder = 'Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder = 'Post Code']")
    WebElement postcode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(), 'Open Account')]")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customer;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(), 'Customers')]")
    WebElement customersButton;

    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    @FindBy(xpath="//button[.='Home']")
    WebElement homeButton;

    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postcode.sendKeys(postCode);
        submitAddCustomerButton.submit();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void openAccountFunctionality(WebDriver driver, String customerName, String currencyName, String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(customer, customerName, "text");
        BrowserUtils.selectBy(currency, currencyName, "text");
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
    }

    public void customersFunctionality(WebDriver driver, String firstName, String lastName, String postcode){
        customersButton.click();
        searchBar.sendKeys(firstName);
        List<String> expectedInfo = Arrays.asList(firstName, lastName,postcode);
        for(int i = 0; i < allInformation.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInfo.get(i));
        }
    }

    public void clickHomeButton(){
        homeButton.click();
    }


}
