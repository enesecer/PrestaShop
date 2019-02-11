package com.Presta.Pages;

import com.Presta.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage {

    public CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//table[@id='cart_summary']//tbody//tr//td[7]")
    public List<WebElement> deleteIcon;

    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement verify1product;

    @FindBy(xpath = "//p[.='Your shopping cart is empty.']")
    public WebElement emptyCart;
}
