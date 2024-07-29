package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;

public class HomePage extends TestBase {
    String homePageName=prop.getProperty("homepagetext");
    @FindBy(xpath = "//span[contains(text(),'Prateek Bhardwaj')]")
    @CacheLookup
    WebElement nameImage;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public void validateHomePage(){
       if(nameImage.isDisplayed()){
           System.out.println("We are logged in successfully");
       }
       else {
           System.out.println("We are on the wrong page");
       }
    }


}
