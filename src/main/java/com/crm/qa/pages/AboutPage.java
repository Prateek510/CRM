package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends TestBase {
    @FindBy(xpath="//a[contains(text(),'About')]")
    @CacheLookup
    WebElement aboutTab;
    @FindBy(xpath="//h1[contains(text(),'About Us')]")
    @CacheLookup
    WebElement aboutUsImage;


    public AboutPage(){
        PageFactory.initElements(driver,this);
    }
    public void aboutUsPage(){
        aboutTab.click();
        aboutUsImage.isDisplayed();
    }
}
