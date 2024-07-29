package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath="//span[contains(text(),'Contacts')]")
    WebElement contactsIcon;


    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }
    public void navigateToContactsPage(){
        contactsIcon.click();
    }
    public String getTitleContactsPage(){
        return driver.getTitle();
    }

}
