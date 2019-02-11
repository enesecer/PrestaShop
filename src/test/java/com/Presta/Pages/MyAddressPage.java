package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {

    public MyAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='My addresses']")
    public WebElement addresses;

    @FindBy(xpath = "//span[.='Add a new address']")
    public WebElement addNewAddress;

    @FindBy(id = "submitAddress")
    public WebElement addressClickSave;

    @FindBy(xpath = "(//div[@class='alert alert-danger'])//ol//li")
    public WebElement nameErrorMsg;


    @FindBy(xpath = "//ul[@class='footer_links clearfix']//li[1]//a//span//i")
    public WebElement backToYourAccount;

    @FindBy(xpath = "//span[@class='address_address1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//ul//li[5]//span")
    public WebElement cityAddress;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//ul//li[5]//span[2]")
    public WebElement stateAddress;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//ul//li[5]//span[3]")
    public WebElement zipCodeAddress;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//ul//li[6]//span[1]")
    public WebElement countryAddress;




}
