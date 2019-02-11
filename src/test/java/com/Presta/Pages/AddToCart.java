package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCart {
    public AddToCart(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
    public WebElement insideCartgetSuccesfullMessage;

    @FindBy(id = "layer_cart_product_attributes")
    public WebElement insideCartsizes;

    @FindBy(id = "layer_cart_product_quantity")
    public WebElement insideCartquantity;

    @FindBy(id = "layer_cart_product_title")
    public WebElement cartProductName;

    @FindBy(id = "layer_cart_product_price")
    public WebElement cartProductPrice;

     @FindBy(xpath = "//a[@title='Proceed to checkout']")
     public WebElement proceedTo;

    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement closeWindow;

    @FindBy(xpath = "//div[@itemprop='offers']")
    public List<WebElement> prices;





}
