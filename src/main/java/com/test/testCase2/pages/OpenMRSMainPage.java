package com.test.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenMRSMainPage {

    public OpenMRSMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement location;

    @FindBy(xpath = "//div[@id='home-container']//h4")
    WebElement header;

    @FindBy(xpath = "//li[@locationname='Pharmacy']")
    WebElement pharmacyButton;

    @FindBy(xpath = "//a//img")
    WebElement logoButton;

    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPatientButton;

    @FindBy(xpath = "//i[@class='icon-user']")
    WebElement registerPatientButton;

    public void validateLocationAndHeader(String expectedLocation, String expectedHeader) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(location), expectedLocation);
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }

    public void validateLocationSwitch(String expectedLocation, String expectedHeader) throws InterruptedException {
        location.click();
        Thread.sleep(1000);
        pharmacyButton.click();
        Thread.sleep(1000);
        logoButton.click();
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(location), expectedLocation);
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Thread.sleep(500);
    }

    public void findPatientRecord() throws InterruptedException {
        findPatientButton.click();
        Thread.sleep(500);
    }

    public void registerPatient() throws InterruptedException {
        registerPatientButton.click();
        Thread.sleep(500);
    }

}
