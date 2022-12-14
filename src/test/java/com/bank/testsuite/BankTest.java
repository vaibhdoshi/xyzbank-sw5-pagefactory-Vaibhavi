package com.bank.testsuite;


import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    OpenAccountPage openAccountPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        openAccountPage = new OpenAccountPage();
        accountPage = new AccountPage();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.clickOnFirstName();
        addCustomerPage.enterFirstName("Harry");
        addCustomerPage.enterLastName("Potter");
        addCustomerPage.enterPostcode("HA11AF");
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertEquals(addCustomerPage.getTextFromPopupWindow(), "Customer added successfully with customer id :6");
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.clickOnCustomerTab();
        openAccountPage.searchCustomerThatCreatedInTheFirstPlace();
        openAccountPage.clickOnCurrencyTab();
        openAccountPage.selectCurrencyPound();
        openAccountPage.clickOnProcessButton();
        Assert.assertEquals(openAccountPage.getTextFromPopupWindow(), "Account created successfully with account Number :1016");
    }

    @Test(groups = {"regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnCustomerLogin();
        customerLoginPage.searchCustomerYouCreated();
        customerLoginPage.selectName();
        customerLoginPage.clickOnloginButton();
        //customerLoginPage.verifyLogoutTab();
        customerLoginPage.clickOnLogoutButton();
        Assert.assertEquals(customerLoginPage.verifyYourNameTextDisplay(), "Your Name :");
    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLogin();
        customerLoginPage.searchCustomerYouCreated();
        customerLoginPage.selectName();
        customerLoginPage.clickOnloginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositTab1();
        Assert.assertEquals(accountPage.verifyDepositMessage(), "Deposit Successful");
    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnCustomerLogin();
        customerLoginPage.searchCustomerYouCreated();
        customerLoginPage.selectName();
        customerLoginPage.clickOnloginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositTab1();
        accountPage.clickOnWithdrawalButton();
        accountPage.enterAmount("50");
        accountPage.clickOnWithdrawButton();
        Assert.assertEquals(accountPage.verifyMessageTransactionSuccessful(), "Transaction Failed. You can not withdraw amount more than the balance.");
    }
}