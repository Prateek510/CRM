package com.crm.qa.testcases;

import com.crm.qa.Utils.TestUtil;
import com.crm.qa.Utils.WebEventListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateContactPage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

@Listeners(WebEventListener.class)
public class CreateContactsPageTest extends TestBase {
    ContactsPage contactsPage;
    LoginPage loginPage;
    CreateContactPage createContactPage;
    TestUtil testUtil;
    public CreateContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        contactsPage=new ContactsPage();
        loginPage=new LoginPage();
        createContactPage=new CreateContactPage();
        loginPage.clickLogin();
        loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
        loginPage.loginSuccess();
        contactsPage.navigateToContactsPage();
    }

    @DataProvider
    public Object[][] gettestData() throws IOException {
        Object data[][]= TestUtil.getTestData("contacts");
        return data;
    }

    @Test(priority = 1)
    public void clickContactsPageButtonTest(){
        createContactPage.clickCreateButton();
    }
    @Test(priority = 2,dataProvider = "gettestData")
    public void enterContactDetailsTest(String firstName,String lastName,String company){
        createContactPage.enterContactDetails(firstName,lastName,company);
    }

}
