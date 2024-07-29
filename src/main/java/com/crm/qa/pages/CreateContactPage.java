package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
    @CacheLookup
    WebElement createButton;
    @FindBy(name="first_name")
            @CacheLookup
    WebElement firstName;
    @FindBy(name="last_name")
            @CacheLookup
    WebElement lastName;
    @FindBy(name="company")
            @CacheLookup
    WebElement company;
    public CreateContactPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickCreateButton(){
        createButton.click();
    }
    public void enterContactDetails(String firstNameValue,
                                    String lastNameValue,String companyValue){
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        company.sendKeys(companyValue);
    }


}
