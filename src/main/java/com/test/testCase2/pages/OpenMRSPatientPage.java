package com.test.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenMRSPatientPage {
    public OpenMRSPatientPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    WebElement newPatientHeader;

    @FindBy(xpath = "//div[@class='identifiers']//span")
    WebElement patientID;

    @FindBy(xpath = "//i[@class='icon-home small']")
    WebElement homePageButton;

    @FindBy(xpath = "//li//i[@class='icon-remove']")
    WebElement deletePatientButton;

    @FindBy(css = "#delete-reason")
    WebElement deleteReasonField;

    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[.='Confirm']")
    WebElement confirmButton;

    @FindBy(css ="#delete-reason-empty")
    WebElement reasonEmptyMessage;

    public void validatePatientRegistration(String firstName,String lastName) throws InterruptedException {
        String header = BrowserUtils.getText(newPatientHeader);
        Assert.assertTrue(header.contains(firstName) && header.contains(lastName));
        Thread.sleep(500);
        Assert.assertTrue(patientID.isDisplayed());
    }

    public void goHomePage(){
        homePageButton.click();
    }

    public void deletePatient(String expectedReasonEmptyMessage, String reasonDelete) throws InterruptedException {
        deletePatientButton.click();
        Thread.sleep(300);
        confirmButton.click();
        Thread.sleep(300);
        Assert.assertEquals(BrowserUtils.getText(reasonEmptyMessage), expectedReasonEmptyMessage);
        Thread.sleep(300);
        deleteReasonField.sendKeys(reasonDelete);
        Thread.sleep(300);
        confirmButton.click();
        Thread.sleep(300);
    }


}
