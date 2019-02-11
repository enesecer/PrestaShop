package com.Presta.Tests.smoke_test;

import com.Presta.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.*;


public class ProductInfoTest extends TestBase {

    /**
     * Product information-price:
     * 1.Go to http://automationpractice.com/index.php
     * 2.Click on any product
     * 3.Verify that same name and price displayed as on the home page
     */

    private int random = (int) (Math.random() * 6) + 1;

    @Test(priority = 4)
    public void infoPrice() {


        //Get Name and Price Info from HomePage
        String productNameBeforeClick = pages.getHomePage().findNameOfTheProduct(random).getText();
        String productPriceBeforeClick = pages.getHomePage().randomProductPrice(random).getText();

        //2.Click on any product
        pages.getHomePage().findNameOfTheProduct(random).click();

        BrowserUtils.waitFor(2);

        //Get Name and Price Info from Product Page
        String nameAfterClick = pages.getProductInformation().afterClickName.getText();
        String priceAfterClick = pages.getProductInformation().afterClickPrice.getText();

        //3.Verify that same name and price displayed as on the home page
        Assert.assertEquals(productNameBeforeClick, nameAfterClick);
        Assert.assertEquals(productPriceBeforeClick, priceAfterClick);
    }

    /**
     * Product information-details:
     * 4.Verify that default quantity is 1
     * 5.Verify that default size is S
     * 6.Verify that size options are S, M, L
     */

    @Test(priority = 5)
    public void detailInfo() {
        //2.Click on any product
        pages.getHomePage().findNameOfTheProduct(random).click();

        //4.Verify that default quantity is 1
        Assert.assertEquals(pages.getProductInformation().quantitiy.getAttribute("value"), "1");

        //5.Verify that default size is S
        Select select = BrowserUtils.select(pages.getProductInformation().size);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "S");

        //6.Adding all sizes to the List
        List<String> allSizes = new ArrayList<>();
        allSizes.add("S");
        allSizes.add("M");
        allSizes.add("L");

        //6.Verify that size options are S, M, L
        List<WebElement> actualSizes = select.getOptions();
        for (int i = 0; i < allSizes.size(); i++) {
            if (allSizes.get(i).equals(actualSizes.get(i).getText())) {
                Assert.assertEquals(allSizes.get(i), actualSizes.get(i).getText());
            }
        }
    }

    /**
     * 7.Click on Add to cart
     * 8.Verify confirmation message “Product successfully added to your shopping cart”
     * 9.Verify that default quantity is 1
     * 10.Verify that default size is S
     * 11.Verify that same name and price displayed as on the home page
     */

    @Test(priority = 6)
    public void addToCartVerify() {

        String productNameBeforeClick = pages.getHomePage().findNameOfTheProduct(random).getText();
        String productPriceBeforeClick = pages.getHomePage().randomProductPrice(random).getText();
        //2.Click on any product
        pages.getHomePage().findNameOfTheProduct(random).click();

        // 7.Click on Add to cart
        pages.getaddToCart().addToCart.click();

        BrowserUtils.waitFor(1);

        //8.Verify confirmation message “Product successfully added to your shopping cart”
        Assert.assertEquals(pages.getaddToCart().insideCartgetSuccesfullMessage.getText(),
                "Product successfully added to your shopping cart");

        //9.Verify that default quantity is 1
        Assert.assertEquals(pages.getaddToCart().insideCartquantity.getText(), "1");

        //10.Verify that default size is S
        String defaultSize = pages.getaddToCart().insideCartsizes.getText().substring(7).trim();
        Assert.assertEquals(defaultSize, "S");

        //11.Verify that same name and price displayed as on the home page


        Assert.assertEquals(productNameBeforeClick, pages.getaddToCart().cartProductName.getText().trim());
        Assert.assertEquals(productPriceBeforeClick, pages.getaddToCart().cartProductPrice.getText().trim());


    }


}
