package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositTab;
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement depositSuccessfulMessage;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawal;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawTab;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyMessage;


    public void clickOnDepositTab() {
        Reporter.log("Click on deposit tab" + depositButton.toString());
        clickOnElement(depositButton);
    }

    public void enterAmount(String text) {
        Reporter.log("Enter Amount " + text + " to amountfield " + amount.toString());
        sendTextToElement(amount, text);
    }

    public void clickOnDepositTab1() {
        Reporter.log("Click on deposit tab1" + depositTab.toString());
        clickOnElement(depositTab);

    }

    public String verifyDepositMessage() {
        Reporter.log("verify deposit message" + depositSuccessfulMessage.toString());
        return getTextFromElement(depositSuccessfulMessage);
    }

    public void clickOnWithdrawalButton() {
        Reporter.log("Click on withdrawal button" + withdrawal.toString());
        clickOnElement(withdrawal);
    }

    public void clickOnWithdrawButton() {
        Reporter.log("Click on withdraw button" + withdrawTab.toString());
        clickOnElement(withdrawTab);
    }

    public String verifyMessageTransactionSuccessful() {
        Reporter.log("verify message transaction successful" + verifyMessage.toString());
        return getTextFromElement(verifyMessage);
    }
}

