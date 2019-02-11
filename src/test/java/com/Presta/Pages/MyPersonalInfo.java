package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInfo {
    public MyPersonalInfo(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='My personal information']")
    public WebElement myPersonal;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement last;

    @FindBy(name = "submitIdentity")
    public WebElement clickSave;

    @FindBy(xpath = "//li[.='The password you entered is incorrect.']")
    public WebElement errorPass;

    @FindBy(xpath = "(//a[@class='btn btn-default button button-small'])[2]")
    public WebElement backToAccount;

    public String title(){

        return Driver.getDriver().getTitle();
    }
}
