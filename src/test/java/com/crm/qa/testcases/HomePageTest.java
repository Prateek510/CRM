package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        loginPage.clickLogin();
        loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
        loginPage.loginSuccess();
    }
    @Test (priority = 1)
    public void validateHomePageTitleTest(){
       String homePageTitle= homePage.getTitle();
        Assert.assertEquals(homePageTitle,"Cogmento CRM",
                "Home page title not matched");
    }
    @Test (priority = 2)
    public void validateHomePageTest(){
        homePage.validateHomePage();
    }
}
