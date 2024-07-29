package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ContactsPageTest extends TestBase {

    ContactsPage contactsPage;
    LoginPage loginPage;
    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        contactsPage=new ContactsPage();
        loginPage=new LoginPage();
        loginPage.clickLogin();
        loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
        loginPage.loginSuccess();
    }
    @Test(priority = 1)
    public void validateTitleContactsPageTest(){
     String titleContactsPage=   contactsPage.getTitleContactsPage();
        Assert.assertEquals(titleContactsPage,"Cogmento CRM",
                "You are on the wrong page ");
    }

    @Test(priority = 2)
    public void clickContactsIconTest(){
        contactsPage.navigateToContactsPage();
    }
}
