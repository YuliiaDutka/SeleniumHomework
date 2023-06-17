package com.test.testCase2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSLoginPage {

    public OpenMRSLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(css = "#Laboratory")
    WebElement laboratoryButton;

    @FindBy(css = "#loginButton")
    WebElement loginButton;

    public void loginFunctionality(String username, String password) throws InterruptedException {
        usernameField.sendKeys(username);
        Thread.sleep(500);
        passwordField.sendKeys(password);
        Thread.sleep(500);
        laboratoryButton.click();
        Thread.sleep(500);
        loginButton.click();
        Thread.sleep(1000);
    }

}
