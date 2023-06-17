package com.test.testCase2.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenMRSFindPatientPage {

    public OpenMRSFindPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchBar;

    @FindBy(xpath = "//tr//td[2]")
    List<WebElement> patientNames;

    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> patientID;

    public void validatePatientName(String patientFullName) throws InterruptedException {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < patientID.size(); i++) {

            String id = BrowserUtils.getText(patientID.get(i));
            String name = BrowserUtils.getText(patientNames.get(i));

            if(map.containsKey(id)){
                Assert.fail("Duplicate id found: " + id);
            }else{
                map.put(id, name);
            }
        }
        Thread.sleep(500);
        Assert.assertTrue(map.containsValue(patientFullName));
    }

    public void findPatientFromList(String patientFullName) throws InterruptedException {
        for(WebElement name : patientNames){
            if(BrowserUtils.getText(name).equals(patientFullName)){
                name.click();
                break;
            }
        }
        Thread.sleep(1000);
    }

    public void validatePatientIsDeleted(String patientFullName){
        for(WebElement name : patientNames){
            Assert.assertTrue(!BrowserUtils.getText(name).equals(patientFullName));
        }

    }
}
