package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTest {


    @Test
    public void validateWelcomeMessage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Yuliia", "Dutka", "60018",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver, "Yuliia Dutka", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality(driver, "Yuliia", "Dutka", "60018");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.chooseUserFunctionality(driver, "Yuliia Dutka");
        customerPage.welcomeMessageValidation("Welcome Yuliia Dutka !!");
    }

    @Test
    public void validateDepositFunctionality(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Yuliia", "Dutka", "60018",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver, "Yuliia Dutka", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality(driver, "Yuliia", "Dutka", "60018");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.chooseUserFunctionality(driver, "Yuliia Dutka");
        customerPage.welcomeMessageValidation("Welcome Yuliia Dutka !!");
        customerPage.validateDepositFunctionality("500", "Deposit Successful");
    }

    @Test
    public void validateWithdrawalFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Yuliia", "Dutka", "60018",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver, "Yuliia Dutka", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality(driver, "Yuliia", "Dutka", "60018");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.chooseUserFunctionality(driver, "Yuliia Dutka");
        customerPage.welcomeMessageValidation("Welcome Yuliia Dutka !!");
        customerPage.validateDepositFunctionality("500", "Deposit Successful");
        customerPage.validateWithdrawalFunctionality("300", "Transaction successful");
    }

    @Test
    public void validateTransactionsFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Yuliia", "Dutka", "60018",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountFunctionality(driver, "Yuliia Dutka", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality(driver, "Yuliia", "Dutka", "60018");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.chooseUserFunctionality(driver, "Yuliia Dutka");
        customerPage.welcomeMessageValidation("Welcome Yuliia Dutka !!");
        customerPage.validateDepositFunctionality("500", "Deposit Successful");
        customerPage.validateWithdrawalFunctionality("300", "Transaction successful");
        customerPage.validateTransactionsFunctionality();
    }
}
