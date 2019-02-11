package com.Presta.Tests.functional_test.cartDetail;

import com.Presta.Utilities.*;
import static com.Presta.Utilities.BrowserUtils.*;
import org.junit.Assert;

import org.testng.annotations.*;

public class cartLoginTest extends TestBase {


    /**
     * Cart LoginTest
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Add any product in the homepage to the cart
     * 4.Hover over the cart icon
     * 5.Verify that cart contains the product
     * 6.Login as any valid user
     * 7.Hover over the cart icon
     * 8.Verify that cart information is same as step 5
     */

    @Test(description = "Check the product you added from HomePage displays ")
    public void LoginTest(){

        extentLogger = report.createTest("Cart Login Test");
        //Find the Product First
        int rd = (int)(Math.random()*7)+1;
        hover(pages.getHomePage().findNameOfTheProduct(rd));

        //get the text of the product
        extentLogger.info("get the text of the random product");
        String getTextOfTheProduct = pages.getHomePage().findNameOfTheProduct(rd).getText();

        //3.Add any product in the homepage to the cart
        extentLogger.info("Click add to cart that selected by randomly");
        pages.getHomePage().addToCart(rd).click();

        //close the pop-up windows
        extentLogger.info("Close add to cart window");
        pages.getaddToCart().closeWindow.click();

        //4.Hover over the cart icon
        extentLogger.info("hover over the cart icon to see details");
        hover(pages.getHomePage().cartIcon);

        //5.Verify that cart contains the product (Verifying with the names)
        extentLogger.info("Verifying that cart contains the product");
        Assert.assertEquals(pages.getHomePage().cartProductNameText.getAttribute("title"), getTextOfTheProduct);

        //6.Login as any valid user
        extentLogger.info("Click signIn button");
        pages.getLoginPage().signIn.click();
        pages.getLoginPage().login(ConfigurationReader.getProperty("email"), ConfigurationReader.getProperty("password"));


        //7.Hover over the cart icon
        extentLogger.info("hover over the cart icon");
        hover(pages.getHomePage().cartIcon);

        //8.Verify that cart information is same as step 5
        extentLogger.info("Verifying that cart contains the product");
        Assert.assertEquals(pages.getHomePage().cartProductNameText.getAttribute("title"), getTextOfTheProduct);
        extentLogger.pass("Test Completed");
    }
}
