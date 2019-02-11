package com.Presta.Utilities;

import com.Presta.Pages.*;


public class Pages {

    private MyAddressPage myAddressPage;
    private ProductInformation productInformation;
    private LoginPage loginPage;
    private HomePage homePage;
    private AddToCart addToCart;
    private MyPersonalInfo myPersonalInfo;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private CheckOutPage checkOutPage;


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MyAddressPage getMyAddressPage() {
        if (myAddressPage == null) {
            myAddressPage = new MyAddressPage();
        }
        return myAddressPage;
    }

    public ProductInformation getProductInformation() {
        if (productInformation == null) {
            productInformation = new ProductInformation();
        }
        return productInformation;
    }

    public HomePage getHomePage() {

        if (homePage == null) {
            homePage = new HomePage();

        }
        return homePage;
    }

    public AddToCart getaddToCart() {

        if (addToCart == null) {
            addToCart = new AddToCart();

        }
        return addToCart;
    }

    public MyPersonalInfo getMyPersonalInfo() {
        if (myPersonalInfo == null) {
            myPersonalInfo = new MyPersonalInfo();
        }
        return myPersonalInfo;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }

    public SignInPage getSignInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage();
        }
        return signInPage;
    }

    public MyAccountPage getMyAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPage();
        }
        return myAccountPage;
    }

    public CheckOutPage getCheckOutPage(){
        if(checkOutPage==null){
            checkOutPage=new CheckOutPage();
        }
        return checkOutPage;
    }

}
