package com.Presta.Pages;

import com.Presta.Utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[1]")
    public WebElement signIn;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement pass;


    public void login(String mail, String p){
        signIn.click();

        email.sendKeys(mail);

        pass.sendKeys(p+ Keys.ENTER);
    }

        public String title(){

        return Driver.getDriver().getTitle();
    }
}
