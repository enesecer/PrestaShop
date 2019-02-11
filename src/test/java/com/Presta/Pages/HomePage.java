package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (className = "logout")
    public WebElement signOutButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement topLeftName;//find the username on right-top

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement cartIcon;

    @FindBy(xpath = "//div[@class='cart-info']//div[1]//a[@class='cart_block_product_name']") //this xpath needs to be improve!
    public WebElement cartProductNameText;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    public WebElement emptyWord;

    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    public WebElement deleteIcon;

    @FindBy(xpath = "//ul[@id='homefeatured']//li[5]//h5//a")
    public WebElement onSaleProduct;

    @FindBy(xpath = "(//span[@class='price product-price'])[10]")
    public WebElement onSaleProductPrice;

    @FindBy(xpath = "(//span[.='Total']/../span)[1]")
    public WebElement cartTotal;




    public WebElement findNameOfTheProduct(int random){
        return Driver.getDriver().findElement(By.xpath("//ul[@id='homefeatured']//li["+random+"]//h5//a"));
    }

    public WebElement addToCart(int rd){
        return Driver.getDriver().findElement(
                By.xpath("//ul[@id='homefeatured']//li[" + rd + "]//span[contains(text(),'Add to cart')]"));
    }

    public WebElement randomProductPrice(int num){
        num = num * 2;
        String xpath = "(//div[@itemprop='offers'])["+num+"]//span";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


}
