package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLogin;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLogin;


    public void clickOnCustomerLogin() {
        Reporter.log("Click on customer login" + customerLogin.toString());
        clickOnElement(customerLogin);
    }

    public void clickOnBankManagerLoginTab() {
        Reporter.log("Click on bankmanager login" + bankManagerLogin.toString());
        clickOnElement(bankManagerLogin);
    }

}
