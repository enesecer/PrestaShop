package com.Presta.Tests.functional_test.cartDetail;

import com.Presta.Utilities.*;
import static com.Presta.Utilities.BrowserUtils.*;
import org.junit.Assert;

import org.testng.annotations.*;

public class CartIconDeleteTest extends TestBase {

    /**
     * Cart Icon DeleteTest
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Add any product in the homepage to the cart
     * 4.Click on Continue shopping
     * 5.Hover over the cart icon
     * 6.Click the x to delete the product
     * 7.Verify word empty is displayed in the Cart icon
     */

    @Test(description = "Cart Icon Delete Test")
        public void deleteIcon(){

        int rd = (int)(Math.random()*7)+1;
        hover(pages.getHomePage().findNameOfTheProduct(rd));

        //3.Add any product in the homepage to the cart
        pages.getHomePage().addToCart(rd).click();

        //4.Click on Continue shopping
        pages.getaddToCart().closeWindow.click();

        //5.Hover over the cart icon
        hover(pages.getHomePage().cartIcon);

        // 6.Click the x to delete the product
        pages.getHomePage().deleteIcon.click();


        waitFor(2);
        //7.Verify word empty is displayed in the Cart icon
        Assert.assertTrue(pages.getHomePage().emptyWord.isDisplayed());

    }
}
