package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation {

    public ProductInformation() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "our_price_display")
    public WebElement afterClickPrice;

    @FindBy(xpath = "//h1[@itemprop='name']")
    public WebElement afterClickName;

    @FindBy(xpath = "//input[@name='qty']")
    public WebElement quantitiy;

    @FindBy(xpath = "//select[@name='group_1']")
    public WebElement size;





}
