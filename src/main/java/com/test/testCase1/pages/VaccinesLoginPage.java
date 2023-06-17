package com.test.testCase1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VaccinesLoginPage {

    public VaccinesLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//button[.='Register']")
    WebElement registerButton;


    public void registerNewAccount(String username, String password) throws InterruptedException {
        usernameField.clear();
        Thread.sleep(500);
        passwordField.clear();
        Thread.sleep(500);
        registerButton.click();
        Thread.sleep(1000);
        usernameField.sendKeys(username);
        Thread.sleep(500);
        passwordField.sendKeys(password);
        Thread.sleep(500);
        registerButton.click();
        Thread.sleep(1000);
    }

    public void loginIntoAccount(String username, String password) throws InterruptedException {
        usernameField.clear();
        Thread.sleep(500);
        usernameField.sendKeys(username);
        Thread.sleep(500);
        passwordField.clear();
        Thread.sleep(500);
        passwordField.sendKeys(password);
        Thread.sleep(500);
        loginButton.click();
        Thread.sleep(1000);
    }


}
