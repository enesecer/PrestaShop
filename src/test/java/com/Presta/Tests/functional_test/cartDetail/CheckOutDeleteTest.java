package com.Presta.Tests.functional_test.cartDetail;

import com.Presta.Utilities.*;
import static com.Presta.Utilities.BrowserUtils.*;


import org.testng.Assert;
import org.testng.annotations.*;

public class CheckOutDeleteTest extends TestBase {

    /**
     * Cart Checkout DeleteTest
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Add any product in the homepage to the cart
     * 4.Click on Continue shopping
     * 5.Add another product in the homepage to the cart
     * 6.Click on Proceed to checkout
     * 7.Verify message Your shopping cart contains: 2 Products
     * 8.Click the delete icon to delete one of the products
     * 9.Verify message Your shopping cart contains: 1 Product
     * 10.Click the delete icon to delete the second product
     * 11.Verify message Your shopping cart is empty.
     */

    @Test(description = "Delete the item at Checkout and verify the messages")
    public void checkOutDelete(){

        extentLogger=report.createTest("Checkout Delete Product Test");
        int rd = (int)(Math.random()*7)+1;
        extentLogger.info("Find randomly product and hover it");
        hover(pages.getHomePage().findNameOfTheProduct(rd));

        //3.Add any product in the homepage to the cart
        extentLogger.info("Add any product in the homepage to the cart");
        pages.getHomePage().addToCart(rd).click();

        //4.Click on Continue shopping
        extentLogger.info("Close cart window");
        pages.getaddToCart().closeWindow.click();

        waitFor(2);
        //5.Add another product in the homepage to the cart
        int random = (int)(Math.random()*7)+1;
        extentLogger.info("Add another product in the homepage to the cart");
        hover(pages.getHomePage().findNameOfTheProduct(random));
        pages.getHomePage().addToCart(random).click();

        waitFor(2);
        //6.Click on Proceed to checkout
        extentLogger.info("Click proceedTo");
        pages.getaddToCart().proceedTo.click();
        waitFor(2);

        //7.Verify message Your shopping cart contains: 2 Products
        extentLogger.info("Verify message Your shopping cart contains: 2 Products");
        Assert.assertEquals(pages.getCheckOutPage().shoppingCart.getText(), "Your shopping cart contains: 2 Products");

        //8.Click the delete icon to delete one of the products
            extentLogger.info("Click the delete icon to delete one of the products");
        pages.getCheckOutPage().deleteIcon.get((int)Math.random()*pages.getCheckOutPage().deleteIcon.size()).click();
        waitFor(4);

        //9.Verify message Your shopping cart contains: 1 Product
        extentLogger.info("Verify message Your shopping cart contains: 1 Product");
        Assert.assertEquals(pages.getCheckOutPage().shoppingCart.getText(), "Your shopping cart contains: 1 Product");

        //10.Click the delete icon to delete the second product
        extentLogger.info("Click the delete icon to delete the second product");
        pages.getCheckOutPage().deleteIcon.get((int)Math.random()*pages.getCheckOutPage().deleteIcon.size()).click();
        waitFor(4);

        //11.Verify message Your shopping cart is empty.
        extentLogger.info("Verify message Your shopping cart is empty.");
        Assert.assertEquals(pages.getCheckOutPage().emptyCart.getText(), "Your shopping cart is empty.");
        extentLogger.pass("Test Completed Successfully");
    }
}
