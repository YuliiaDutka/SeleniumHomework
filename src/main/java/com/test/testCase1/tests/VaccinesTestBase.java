package com.test.testCase1.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class VaccinesTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.navigate().to("http://codefish-io-qa.s3-website-ap-northeast-1.amazonaws.com/");
    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult){
//        if(!iTestResult.isSuccess()){
//            BrowserUtils.getScreenShot(driver, "blazePictures");
//        }
//        driver.quit();
    }
}
