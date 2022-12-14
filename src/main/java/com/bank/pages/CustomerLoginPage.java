package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement nameMessage;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName ;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logout ;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    By logoutTab ;


    public void verifyLogoutTab() {
        Reporter.log("verify logout tab" +logoutTab.toString());
        verifyThatElementIsDisplayed(logoutTab);
    }


    public void searchCustomerYouCreated() {
        Reporter.log("search customer ypu create" +customerName.toString());
        mouseHoverToElementAndClick(customerName);
    }

    public void selectName() {
        Reporter.log("select name" +customerName.toString());
        selectByVisibleTextFromDropDown(customerName, "Harry Potter");
    }

    public void clickOnloginButton() {
        Reporter.log("click on login button" +login.toString());
        clickOnElement(login);
    }


    public void clickOnLogoutButton() {
        Reporter.log("click on logout button" +logout.toString());
        clickOnElement(logout);
    }

    public String verifyYourNameTextDisplay() {
        Reporter.log("verify your name text display" +nameMessage.toString());
        return getTextFromElement(nameMessage);
    }


}
