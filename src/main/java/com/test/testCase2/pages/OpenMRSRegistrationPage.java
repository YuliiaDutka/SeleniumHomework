package com.test.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class OpenMRSRegistrationPage {

    public OpenMRSRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='givenName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='familyName']")
    WebElement lastNameField;

    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement genderLabel;

    @FindBy(css = "#gender-field")
    WebElement genderField;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthdateLabel;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    WebElement dayOfBirthField;

    @FindBy(xpath = "//select[@name='birthdateMonth']")
    WebElement monthOfBirthField;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    WebElement yearOfBirthField;

    @FindBy(xpath = "//span[.='Address']")
    WebElement addressLabel;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressField;

    @FindBy(xpath = "//input[@id='cityVillage']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='stateProvince']")
    WebElement stateField;

    @FindBy(xpath = "//input[@id='country']")
    WebElement countryField;

    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement postcodeField;

    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumberLabel;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//span[@id='confirmation_label']")
    WebElement confirmationLabel;

    @FindBy(xpath = "//input[@id='submit']")
    WebElement confirmButton;

    @FindBy(xpath = "//div[@id='dataCanvas']//p")
    List<WebElement>allCustomerInfo;

    public void patientRegistration(String firstName, String lastName, String gender, String dayOfBirth, String monthOfBirth,
                                    String yearOfBirth, String address, String city, String state, String country,
                                                   String postcode, String phoneNumber) throws InterruptedException {
        firstNameField.sendKeys(firstName);
        Thread.sleep(300);
        lastNameField.sendKeys(lastName);
        Thread.sleep(300);
        genderLabel.click();
        Thread.sleep(300);
        BrowserUtils.selectBy(genderField,gender,"text");
        Thread.sleep(300);
        birthdateLabel.click();
        Thread.sleep(300);
        dayOfBirthField.sendKeys(dayOfBirth);
        Thread.sleep(300);
        Select select = new Select(monthOfBirthField);
        Thread.sleep(300);
        select.selectByVisibleText(monthOfBirth);
        Thread.sleep(300);
        yearOfBirthField.sendKeys(yearOfBirth);
        Thread.sleep(300);
        addressLabel.click();
        Thread.sleep(300);
        addressField.sendKeys(address);
        Thread.sleep(300);
        cityField.sendKeys(city);
        Thread.sleep(300);
        stateField.sendKeys(state);
        Thread.sleep(300);
        countryField.sendKeys(country);
        Thread.sleep(300);
        postcodeField.sendKeys(postcode);
        Thread.sleep(300);
        phoneNumberLabel.click();
        phoneNumberField.sendKeys(phoneNumber);
        Thread.sleep(300);
        confirmationLabel.click();

        List<String> expCustomerInfo = Arrays.asList("Name: "+firstName+", "+lastName,"Gender: "+gender,
                "Birthdate: "+dayOfBirth+", "+monthOfBirth+", "+yearOfBirth,
                "Address: "+address+", "+city+", "+state+", "+country+", "+postcode,
                "Phone Number: "+phoneNumber);
        Thread.sleep(500);
        for (int i = 0; i <allCustomerInfo.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(allCustomerInfo.get(i)),expCustomerInfo.get(i));
        }
        Thread.sleep(300);
        confirmButton.click();
        Thread.sleep(300);
    }
}
