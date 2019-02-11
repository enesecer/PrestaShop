package com.Presta.Tests.functional_test.login;

import com.Presta.Utilities.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest extends TestBase {


    String sendemail = BrowserUtils.faker().name().username() + "@gmail.com";
    String sendFirstName = BrowserUtils.faker().name().firstName();
    String sendLastName = BrowserUtils.faker().name().lastName();
    String sendPassword = BrowserUtils.faker().internet().password();
    String sendStreetAddress = BrowserUtils.faker().address().streetAddress();
    String sendCity = BrowserUtils.faker().address().city();
    String sendZipCode = BrowserUtils.faker().address().zipCode().substring(0, 5);
    String sendMobilePhone = BrowserUtils.faker().phoneNumber().cellPhone();


    /**
     * Registration Test
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Click Sign in link
     * 4.Enter new valid email to the email field
     * 5.Click on Create Account
     * 6.Verify that that email link displays current email
     * 7.Fill out all the required steps
     * 8.Click on Register
     * 9.Verify that correct first and last name is displayed correctly on top right
     * 10.Click on My personal information
     * 11.Verify that personal information is displayed correctly
     * 12.Click on Back to your account
     * 13.Click on My addresses verify that address information is displayed correctly
     * 14.Click on sign out link
     * 15.Login using the email and password if the current user
     * 16.Verify that correct first and last name is displayed correctly on top right
     */

    @Test(description = "Register by fulling all requirements fields")
    public void registrationPage() {

        extentLogger=report.createTest("Registration Test");
        //3.Click Sign in link
        extentLogger.info("Click SignIn Button");
        pages.getLoginPage().signIn.click();

        //4.Enter new valid email to the email field
        extentLogger.info("Send Random Email");
        pages.getSignInPage().signupEmailInput.sendKeys(sendemail);

        //5.Click on Create Account
        extentLogger.info("Click Create Button");
        pages.getSignInPage().createAccountButton.click();
        BrowserUtils.waitFor(2);

        //6.Verify that email link displays current email
        extentLogger.info("Verify email that display");
        Assert.assertEquals(sendemail, pages.getRegistrationPage().email.getAttribute("value"));

        //7.Fill out all the required steps
        extentLogger.info("Send Random firstName");
        pages.getRegistrationPage().firstName.sendKeys(sendFirstName);

        extentLogger.info("Send Random lastName");
        pages.getRegistrationPage().lastName.sendKeys(sendLastName);

        extentLogger.info("Send Random password");
        pages.getRegistrationPage().password.sendKeys(sendPassword);

        extentLogger.info("Send Random streetAddress");
        pages.getRegistrationPage().address.sendKeys(sendStreetAddress);

        extentLogger.info("Send Random City");
        pages.getRegistrationPage().city.sendKeys(sendCity);

        extentLogger.info("Select state with visibility");
        BrowserUtils.select(pages.getRegistrationPage().state).selectByVisibleText("Arizona");

        extentLogger.info("Send Random zipCode");
        pages.getRegistrationPage().zipCode.sendKeys(sendZipCode);

        extentLogger.info("Send Random phoneNumber");
        pages.getRegistrationPage().mobilePhone.sendKeys(sendMobilePhone);

        //8.Click on Register
        extentLogger.info("Click Submit Button");
        pages.getRegistrationPage().submit.click();


        //9.Verify that correct first and last name is displayed correctly on top right
        extentLogger.info("Verify the first and last name with the account holder name");
        Assert.assertEquals(sendFirstName + " " + sendLastName, pages.getHomePage().topLeftName.getText());

        //10.Click on My personal information
        extentLogger.info("Click myPersonal Info");
        pages.getMyPersonalInfo().myPersonal.click();

        // 11.Verify that personal information is displayed correctly
        extentLogger.info("Verify first name");
        Assert.assertEquals(sendFirstName, pages.getMyPersonalInfo().firstName.getAttribute("value"));
        extentLogger.info("Verify last name");
        Assert.assertEquals(sendLastName, pages.getMyPersonalInfo().last.getAttribute("value"));

        //12.Click on Back to your account
        extentLogger.info("Click backToAccount Button");
        pages.getMyPersonalInfo().backToAccount.click();

        // 13.Click on My addresses and verify that address information is displayed correctly
        extentLogger.info("Click myAddresses Button");
        pages.getMyAddressPage().addresses.click();

        //Verify street Address
        extentLogger.info("Verify streetAddress");
        Assert.assertEquals(pages.getMyAddressPage().streetAddress.getText(),sendStreetAddress);

        //Verify City
        extentLogger.info("Verify cityAddress");
        String city = pages.getMyAddressPage().cityAddress.getText();
        city= city.substring(0,city.length()-1);
        Assert.assertEquals(city, sendCity);

        //Verify state
        extentLogger.info("Verify stateAddress");
        Assert.assertEquals(pages.getMyAddressPage().stateAddress.getText(),"Arizona" );

        //Verify zipCode
        extentLogger.info("Verify zipCodeAddress");
        Assert.assertEquals(pages.getMyAddressPage().zipCodeAddress.getText(), sendZipCode);

        //14.Click on sign out link
        extentLogger.info("Click signOut Button");
        pages.getHomePage().signOutButton.click();

        //15.Login using the email and password if the current user
        extentLogger.info("Login as a valid user randomly");
        pages.getSignInPage().signinEmailInput.sendKeys(sendemail);
        pages.getSignInPage().signinPasswordInput.sendKeys(sendPassword);

        extentLogger.info("Click signIn Button");
        pages.getSignInPage().signinButton.click();

        //16.Verify that correct first and last name is displayed correctly on top right
        extentLogger.info("Verify firstName and lastName with accountHolder name");
        Assert.assertEquals(sendFirstName+" "+sendLastName, pages.getHomePage().topLeftName.getText());

        extentLogger.pass("Test Completed Successfully");

    }
}
