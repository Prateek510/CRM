package com.crm.qa.testcases;

import com.crm.qa.Utils.WebEventListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Listeners(WebEventListener.class)
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        loginPage=new LoginPage();
    }
    @Test(priority = 1)
    public void validatePageTitleTest(){
        String title=loginPage.getTitle();
        Assert.assertEquals(title,"#1 Free CRM Power Up your Entire Business Free Forever");
    }
    @Test(priority = 2)
    public void loginTest(){
        loginPage.clickLogin();
        loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
        loginPage.loginSuccess();
    }
}
