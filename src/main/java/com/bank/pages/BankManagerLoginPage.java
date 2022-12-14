package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountTab;


    public void clickOnAddCustomerTab() {
        Reporter.log("click on add customer tab" +addCustomerTab.toString());
        clickOnElement(addCustomerTab);

    }

    public void clickOnOpenAccountTab(){
        Reporter.log("click on open account tab" +openAccountTab.toString());
        clickOnElement(openAccountTab);
    }

}
