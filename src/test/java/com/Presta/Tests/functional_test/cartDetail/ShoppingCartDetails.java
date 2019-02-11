package com.Presta.Tests.functional_test.cartDetail;

import com.Presta.Utilities.*;

import static com.Presta.Utilities.BrowserUtils.*;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;


public class ShoppingCartDetails extends TestBase {

    /**
     * Cart Details
     * 1.Open browser
     * 2.Go to http://automationpractice.com/index.php
     * 3.Click on any product that is not on sale
     * 4.Enter a random quantity between 2 and 5
     * 5.Select a different size
     * 6.Click on add to cart
     * 7.Verify confirmation message Product successfully added to your shopping cart
     * 8.Dismiss the confirmation window by clicking on the x icon
     * 9.Click on the company logo
     * 10.Click on any product that is on sale
     * 11.Enter a random quantity between 2 and 5
     * 12.Select a different size
     * 13.Click on add to cart
     * 14.Verify confirmation message Product successfully added to your shopping cart
     * 15.Dismiss the confirmation window by clicking on the x icon
     * 16.Hover over the Cart icon
     * 17.Verify that correct total is displayed
     * 18.Verify that total is correct based on the price and item count of the products you added to cart.
     * (Shipping is always $2)
     */

    @Test
    public void detailsCart() {

        extentLogger = report.createTest("Details Cart");
        // 3.Click on any product that is not on sale
        int rd = (int) (Math.random() * 7) + 1;
        List<WebElement> prices = new ArrayList<>();
        extentLogger.info("Click on any product that is not on sale");
        for (int i = 0; i < pages.getaddToCart().prices.size(); i++) {
            if (!pages.getaddToCart().prices.get(i).getText().contains("-")) {
                prices.add(pages.getaddToCart().prices.get(i));
            }
        }
        hover(prices.get(rd));

        //get the price of the product and convert it to the double.
        extentLogger.info("get the price of the product and convert it to the double");
        String textOfRegularProduct= pages.getHomePage().randomProductPrice(rd).getText();
        double price = Double.parseDouble(textOfRegularProduct.replace("$", ""));
        pages.getHomePage().findNameOfTheProduct(rd).click();


        waitForVisibility(pages.getProductInformation().quantitiy, 10);

        //4.Enter a random quantity between 2 and 5
        pages.getProductInformation().quantitiy.clear();
        int up = 5;
        int low = 2;
        int r = (int) (Math.random() * (up - low)) + low;
        extentLogger.info("Enter a random quantity between 2 and 5");
        pages.getProductInformation().quantitiy.sendKeys("" + r);

        double totalPriceRegularPr = price*r;

        //5.Select a different size
        extentLogger.info("Select a different size");
        select(pages.getProductInformation().size).selectByVisibleText("M");

        // 6.Click on add to cart
        extentLogger.info("Click on add to cart");
        pages.getaddToCart().addToCart.click();

        waitForVisibility(pages.getaddToCart().insideCartgetSuccesfullMessage, 5);

        //7.Verify confirmation message Product successfully added to your shopping cart
        extentLogger.info("Verify confirmation message Product successfully added to your shopping cart");
        String actual = pages.getaddToCart().insideCartgetSuccesfullMessage.getText();
        String expected = "Product successfully added to your shopping cart";
        Assert.assertEquals(actual, expected);

        //8.Dismiss the confirmation window by clicking on the x icon
        extentLogger.info("Dismiss the confirmation window by clicking on the x icon");
        pages.getaddToCart().closeWindow.click();

        // 9.Click on the company logo
        extentLogger.info("Click on the company logo");
        pages.getMyAccountPage().clickBackHomePage.click();


        waitFor(2);

        String onSaleProductPrice = pages.getHomePage().onSaleProductPrice.getText();
        double onSalePrice = Double.parseDouble(onSaleProductPrice.replace("$", ""));
        // 10.Click on any product that is on sale
        extentLogger.info("Click on any product that is on sale");
        pages.getHomePage().onSaleProduct.click();

        //11.Enter a random quantity between 2 and 5
        extentLogger.info("Enter a random quantity between 2 and 5");
        pages.getProductInformation().quantitiy.clear();
        pages.getProductInformation().quantitiy.sendKeys("" + r);

        double totalPriceOnSale = onSalePrice*r;

        //12.Select a different size
        extentLogger.info("Select a different size");
        select(pages.getProductInformation().size).selectByVisibleText("L");

        // 13.Click on add to cart
        extentLogger.info("Click on add to cart");
        pages.getaddToCart().addToCart.click();

        waitForVisibility(pages.getaddToCart().insideCartgetSuccesfullMessage, 5);

        //14.Verify confirmation message Product successfully added to your shopping cart
        extentLogger.info("Verify confirmation message Product successfully added to your shopping cart");
        String actualOnSale = pages.getaddToCart().insideCartgetSuccesfullMessage.getText();
        String expectedOnSale = "Product successfully added to your shopping cart";
        Assert.assertEquals(actualOnSale, expectedOnSale);

        //15.Dismiss the confirmation window by clicking on the x icon
        extentLogger.info("Dismiss the confirmation window by clicking on the x icon");
        pages.getaddToCart().closeWindow.click();


        //15.1.Click on the company logo
        extentLogger.info("Click on the company logo");
        pages.getMyAccountPage().clickBackHomePage.click();
        waitFor(2);

        //16.Hover over the Cart icon
        extentLogger.info("Hover over the cart Icon");
        hover(pages.getHomePage().cartIcon);


        //get the text of the total and convert to the integer.

        waitForVisibility(pages.getHomePage().cartTotal,5);
        String totalCartIcon = pages.getHomePage().cartTotal.getText();
        double totalPriceCart = Double.parseDouble(totalCartIcon.replace("$", ""));

        // 17.Verify that correct total is displayed
        extentLogger.info("Verify that correct total is displayed");
        Assert.assertEquals( (totalPriceRegularPr + totalPriceOnSale+2), totalPriceCart);
        extentLogger.pass("Test Completed Successfully");


    }
}
