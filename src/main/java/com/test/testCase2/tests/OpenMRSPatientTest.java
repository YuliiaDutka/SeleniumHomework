package com.test.testCase2.tests;

import com.test.testCase2.pages.OpenMRSFindPatientPage;
import com.test.testCase2.pages.OpenMRSLoginPage;
import com.test.testCase2.pages.OpenMRSMainPage;
import com.test.testCase2.pages.OpenMRSPatientPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMRSPatientTest extends OpenMRSTestBase{

    @Parameters({"username", "password", "patientFullNameReg", "expectedReasonEmptyMessage", "reasonDelete"})
    @Test
    public void validateDeletePatientFunctionality(String username, String password, String patientFullName,
                                                   String expectedReasonEmptyMessage, String reasonDelete) throws InterruptedException {
        OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
        openMRSLoginPage.loginFunctionality(username, password);
        OpenMRSMainPage openMRSMainPage = new OpenMRSMainPage(driver);
        openMRSMainPage.findPatientRecord();
        OpenMRSFindPatientPage openMRSFindPatientPage = new OpenMRSFindPatientPage(driver);
        openMRSFindPatientPage.findPatientFromList(patientFullName);
        OpenMRSPatientPage openMRSPatientPage = new OpenMRSPatientPage(driver);
        openMRSPatientPage.deletePatient(expectedReasonEmptyMessage, reasonDelete);
        openMRSFindPatientPage.validatePatientIsDeleted(patientFullName);


    }
}
