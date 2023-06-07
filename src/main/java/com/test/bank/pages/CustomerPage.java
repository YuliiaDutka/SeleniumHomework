package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement userNameDropdown;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmountLine;

    @FindBy(xpath = "//button[.='Deposit']")
    WebElement submitDepositButton;

    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    WebElement successfulDepositMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawalButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawalAmountLine;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement submitWithdrawButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement successfulWithdrawalMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionsButton;

    @FindBy(xpath = "//td[.='500']")
    WebElement deposit;

    @FindBy(xpath = "//td[.='300']")
    WebElement withdrawal;

    @FindBy(xpath = "//strong[.='200']")
    WebElement balance;

    public void chooseUserFunctionality(WebDriver driver, String customerName){
        BrowserUtils.selectBy(userNameDropdown, customerName, "text");
        loginButton.click();
    }

    public void welcomeMessageValidation(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage), expectedMessage);
        Assert.assertTrue(welcomeMessage.isDisplayed() && welcomeMessage.isEnabled());
    }

    public void validateDepositFunctionality(String depositAmount, String expectedSuccessfulDepositMessage){
        depositButton.click();
        depositAmountLine.sendKeys(depositAmount);
        submitDepositButton.click();
        Assert.assertEquals(BrowserUtils.getText(successfulDepositMessage), expectedSuccessfulDepositMessage);
        Assert.assertTrue(successfulDepositMessage.isDisplayed() && successfulDepositMessage.isEnabled());
    }

    public void validateWithdrawalFunctionality(String withdrawalAmount, String expectedSuccessfulWithdrawalMessage) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(1000);
        withdrawalAmountLine.sendKeys(withdrawalAmount);
        submitWithdrawButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(successfulWithdrawalMessage), expectedSuccessfulWithdrawalMessage);
        Assert.assertTrue(successfulWithdrawalMessage.isDisplayed() && successfulWithdrawalMessage.isEnabled());
    }

    public void validateTransactionsFunctionality() throws InterruptedException {
        int balanceAfter = Integer.parseInt(BrowserUtils.getText(balance));
        transactionsButton.click();
        Thread.sleep(1000);
        Assert.assertTrue( Integer.parseInt(BrowserUtils.getText(deposit))-Integer.parseInt(BrowserUtils.getText(withdrawal)) == balanceAfter);
    }
}
