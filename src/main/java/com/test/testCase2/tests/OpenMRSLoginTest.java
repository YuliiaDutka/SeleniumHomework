package com.test.testCase2.tests;

import com.test.testCase2.pages.OpenMRSLoginPage;
import com.test.testCase2.pages.OpenMRSMainPage;
import com.test.testCase2.pages.OpenMRSFindPatientPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMRSLoginTest extends OpenMRSTestBase{

    @Parameters({"username", "password", "expectedLocationLab", "expectedHeaderLab", "expectedLocationPh", "expectedHeaderPh",
    "patientFullName"})
    @Test
    public void validateLoginFunctionality(String username, String password, String expectedLocationLab, String expectedHeaderLab,
                                           String expectedLocationPh, String expectedHeaderPh, String patientFullName) throws InterruptedException {
        OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
        openMRSLoginPage.loginFunctionality(username, password);
        OpenMRSMainPage openMRSMainPage = new OpenMRSMainPage(driver);
        openMRSMainPage.validateLocationAndHeader(expectedLocationLab, expectedHeaderLab);
        openMRSMainPage.validateLocationSwitch(expectedLocationPh, expectedHeaderPh);
        openMRSMainPage.findPatientRecord();
        OpenMRSFindPatientPage openMRSFindPatientPage = new OpenMRSFindPatientPage(driver);
        openMRSFindPatientPage.validatePatientName(patientFullName);
    }
}
