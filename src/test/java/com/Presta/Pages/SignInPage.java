package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email_create")
    public WebElement signupEmailInput;

    @FindBy (id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy (id = "email")
    public WebElement signinEmailInput;

    @FindBy (id = "passwd")
    public WebElement signinPasswordInput;

    @FindBy (id = "SubmitLogin")
    public WebElement signinButton;

}
