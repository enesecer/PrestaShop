package com.Presta.Tests.smoke_test;

import com.Presta.Utilities.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountInfoTest extends TestBase {

    private String accountHolder = "cyber tek";
    private String accountTitle = "My account";


    @BeforeMethod
    public void loginFirst() {
        // 2.Click Sign in link
        pages.getLoginPage().signIn.click();
        // 3.Login using valid username and password
        pages.getLoginPage().login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));
    }

    /**
     * Login: my account
     * 1.Go to http://automationpractice.com/index.php
     * 2.Click Sign in link
     * 3.Login using valid username and password
     * 4.Verify that title contains My account
     * 5.Verify that account holder full name is displayed next to the Sign out link
     */

    @Test(description = "Verifying the title and and Account holder name", priority = 1)
    public void myAccount() {
        System.out.println("Paralel test1: " + Thread.currentThread().getId());
        //4.Verify that title contains My account
        extentLogger = report.createTest("Title and Account Name Verification");
        extentLogger.info("Verify title");
        Assert.assertTrue(pages.getLoginPage().title().contains(accountTitle));

        //5.Verify that account holder full name is displayed next to the Sign out link
        extentLogger.info("Verify AccountHolder name is displayed");
        Assert.assertTrue(pages.getHomePage().topLeftName.isDisplayed());

        extentLogger.pass("Test Completed");


    }

    /**
     * Login: My personal information
     * 6.Click on My personal information button
     * 7.Verify title contains Identity
     * 8.Verify that first name and last name matches the full name on top
     * 9.Click on Save button
     * 10.Verify error message “The password you entered is incorrect.”
     * 11.Click on Back to your account
     * 12.Verify that title contains My account
     */
    @Test(description = "Verifying names and error messages are matching with requirements", priority = 2)
    public void myPersonalInfo() {

        System.out.println("Paralel test2: " + Thread.currentThread().getId());

        extentLogger = report.createTest("My Personal Information");
        // 6.Click on My personal information button
        pages.getMyPersonalInfo().myPersonal.click();

        //7.Verify title contains Identity
        extentLogger.info("Verify title contains certain word");
        Assert.assertTrue(pages.getMyPersonalInfo().title().contains("Identity"));

        //8.Verify that first name and last name matches the full name on top
        String first = pages.getMyPersonalInfo().firstName.getAttribute("value");
        String last = pages.getMyPersonalInfo().last.getAttribute("value");
        extentLogger.info("verify first and last name matching with the Account holder name");
        Assert.assertEquals(first + " " + last, accountHolder);

        //9.Click on Save button
        pages.getMyPersonalInfo().clickSave.click();

        //10.Verify error message “The password you entered is incorrect.”
        extentLogger.info("Verify error message is matching expected error");
        Assert.assertEquals(pages.getMyPersonalInfo().errorPass.getText(), "The password you entered is incorrect.");

        //11.Click on Back to your account
        pages.getMyAddressPage().backToYourAccount.click();

        //12.Verify that title contains My account
        extentLogger.info("Verify title contains expected word");
        Assert.assertTrue(pages.getLoginPage().title().contains(accountTitle));
    }

    /**
     * Login: My addresses
     * 13.Click on My addresses
     * 14.Click on Add a new address
     * 15.Verify that first name and last name matches the full name on top
     * 16.Delete the first name
     * 17.Click save
     * 18.Verify error message “first name is required.”
     */
    @Test(description = "verifying first name error message", priority = 3)
    public void myAddresses() {

        extentLogger = report.createTest("My Addresses");
        // 13.Click on My addresses
        pages.getMyAddressPage().addresses.click();


        //14.Click on Add a new address
        pages.getMyAddressPage().addNewAddress.click();

        //15.Verify that first name and last name matches the full name on top
        String first = pages.getMyPersonalInfo().firstName.getAttribute("value");
        String last = pages.getMyPersonalInfo().last.getAttribute("value");
        extentLogger.info("Verify first name and last name with the Account Holder name");
        Assert.assertEquals(first + " " + last, accountHolder);

        //16.Delete the first name
        extentLogger.info("Delete the firstName");
        pages.getMyPersonalInfo().firstName.clear();

        // 17.Click save
        pages.getMyAddressPage().addressClickSave.click();

        //18.Verify error message “firstname is required.”
        extentLogger.info("Verify the error message");
        Assert.assertEquals(pages.getMyAddressPage().nameErrorMsg.getText(), "firstname is required.");

        extentLogger.pass("Test Completed");

    }

}
