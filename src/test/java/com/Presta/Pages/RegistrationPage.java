package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy (id = "address1")
    public WebElement address;

    @FindBy (id = "city")
    public WebElement city;

    @FindBy (id = "id_state")
    public WebElement state;

    @FindBy (id = "postcode")
    public WebElement zipCode;

    @FindBy (id = "id_country")
    public WebElement country;

    @FindBy (id = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy (id = "submitAccount")
    public WebElement submit;




}
