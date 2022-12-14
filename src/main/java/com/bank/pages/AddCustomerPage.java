package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomer;


    public void clickOnFirstName() {
        Reporter.log("click on firstname" + firstName.toString());
        mouseHoverToElementAndClick(firstName);
    }

    public void enterFirstName(String firstname) {
        Reporter.log("enter firstname" + firstName.toString());
        sendTextToElement(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        Reporter.log("enter lastname" + lastName.toString());
        sendTextToElement(lastName, lastname);
    }

    public void enterPostcode(String postcode1) {
        Reporter.log("enter postcode" + postcode.toString());
        sendTextToElement(postcode, postcode1);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("click on add customer button" + addCustomer.toString());
        clickOnElement(addCustomer);
    }

    public String getTextFromPopupWindow() {
        Reporter.log("Customer added successfully with customer id :6");
        return getTextFromAlert();

    }

}
