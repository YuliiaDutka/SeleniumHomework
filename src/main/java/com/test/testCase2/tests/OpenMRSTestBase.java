package com.test.testCase2.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenMRSTestBase {

        public WebDriver driver;

        @BeforeMethod
        public void setup(){
            driver = DriverHelper.getDriver();
            driver.navigate().to("http://codefish.ninja/openmrs/login.htm");
        }


        @AfterMethod
        public void tearDown(ITestResult iTestResult){
//        if(!iTestResult.isSuccess()){
//            BrowserUtils.getScreenShot(driver, "blazePictures");
//        }
//        driver.quit();
        }
}
