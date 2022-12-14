package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customer;
    @CacheLookup
    @FindBy(id = "currency")
    WebElement currency;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement process;

    public void clickOnCustomerTab(){
        Reporter.log("Click on customer tab" + customer.toString());
        mouseHoverToElementAndClick(customer);
    }
    public void searchCustomerThatCreatedInTheFirstPlace() {
        Reporter.log("search customer that created in the first place" + customer.toString());
        selectByVisibleTextFromDropDown(customer, "Harry Potter");
    }
    public void clickOnCurrencyTab(){
        Reporter.log("click on currency tab" + currency.toString());
        mouseHoverToElementAndClick(currency);
    }

    public void selectCurrencyPound() {
        Reporter.log("select currency pound" + currency.toString());
        selectByVisibleTextFromDropDown(currency,"Pound");
    }

    public void clickOnProcessButton(){
        Reporter.log("Click on process button" + process.toString());
        clickOnElement(process);
    }

    public String getTextFromPopupWindow() {
        Reporter.log("Account created successfully with account Number :1016");
        return getTextFromAlert();

    }
}
