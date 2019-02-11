package com.Presta.Tests.functional_test.cartDetail;

import com.Presta.Utilities.*;
import static com.Presta.Utilities.BrowserUtils.*;
import org.testng.Assert;

import org.testng.annotations.*;

public class cartLogoutTest extends TestBase {

    /**
     * Cart LogoutTest
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Login as any valid user
     * 4.Go back to home page
     * 5.Add any product in the homepage to the cart
     * 6.Hover over the cart icon
     * 7.Verify that cart contains the product
     * 8.Log out
     * 9.Verify the cart contains the word empty
     */

    @Test
    public void logoutTest(){
        //3.Login as any valid user
        extentLogger = report.createTest("Logout Test");
        extentLogger.info("SignIn Click");

        pages.getLoginPage().signIn.click();
        extentLogger.info("Login to page using configuration properties");
        pages.getLoginPage().login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));

        //4.Go back to home page
        extentLogger.info("Click homepage back");
        pages.getMyAccountPage().clickBackHomePage.click();
        waitFor(2);

        //5.Add any product in the homepage to the cart
        int rd = (int)(Math.random()*7)+1;
        extentLogger.info("Add any product in the homePage");
        hover(pages.getHomePage().findNameOfTheProduct(rd));

        //get the text of the product
        extentLogger.info("Get the text of the product");
        String getTextOfTheProduct = pages.getHomePage().findNameOfTheProduct(rd).getText();

        //Click Add to Cart.
        extentLogger.info("Click add to cart");
        pages.getHomePage().addToCart(rd).click();

        //close the pop-up windows
        extentLogger.info("Close the window");
        pages.getaddToCart().closeWindow.click();

        //6.Hover over the cart icon
        extentLogger.info("hover over the cart Icon");
        hover(pages.getHomePage().cartIcon);

        //7.Verify that cart contains the product(with the Name)
        extentLogger.info("Verify that cart contains the product(with the Name)");
        Assert.assertEquals(pages.getHomePage().cartProductNameText.getAttribute("title"), getTextOfTheProduct);

        //8.Log out
        extentLogger.info("Click SignOut button-->Log out");
        pages.getHomePage().signOutButton.click();

        //9.Verify the cart contains the word empty
        extentLogger.info("Verify the cart contains the word empty");
        Assert.assertTrue(pages.getHomePage().emptyWord.getText().contains("empty"));
        extentLogger.pass("Test Completed");

    }
}
