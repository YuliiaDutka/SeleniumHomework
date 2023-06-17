package com.test.testCase2.tests;

import com.test.testCase2.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenMRSRegistrationTest extends OpenMRSTestBase{

    @Parameters({"username", "password", "firstName", "lastName", "gender", "dayOfBirth", "monthOfBirth", "yearOfBirth", "address",
    "city", "state", "country", "postcode", "phoneNumber", "patientFullNameReg"})
    @Test
    public void validateNewPatientRegistration(String username, String password, String firstName, String lastName, String gender,
                                               String dayOfBirth, String monthOfBirth, String yearOfBirth, String address,
                                               String city, String state, String country, String postcode, String phoneNumber,
                                               String patientFullName) throws InterruptedException {
        OpenMRSLoginPage openMRSLoginPage = new OpenMRSLoginPage(driver);
        openMRSLoginPage.loginFunctionality(username, password);
        OpenMRSMainPage openMRSMainPage = new OpenMRSMainPage(driver);
        openMRSMainPage.registerPatient();
        OpenMRSRegistrationPage openMRSRegisterPatientPage = new OpenMRSRegistrationPage(driver);
        openMRSRegisterPatientPage.patientRegistration(firstName, lastName, gender ,dayOfBirth, monthOfBirth, yearOfBirth,
                address, city, state, country, postcode, phoneNumber);
        OpenMRSPatientPage openMRSPatientPage = new OpenMRSPatientPage(driver);
        openMRSPatientPage.validatePatientRegistration(firstName, lastName);
        openMRSPatientPage.goHomePage();
        openMRSMainPage.findPatientRecord();
        OpenMRSFindPatientPage openMRSFindPatientPage = new OpenMRSFindPatientPage(driver);
        openMRSFindPatientPage.validatePatientName(patientFullName);
    }


}
