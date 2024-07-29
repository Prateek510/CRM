package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement homeLoginButton;
@FindBy(name="email")
@CacheLookup
WebElement emailText;
@FindBy(name="password")
@CacheLookup
WebElement passEnter;
@FindBy(xpath="//div[contains(text(),'Login')]")
@CacheLookup
WebElement loginEnter;

public LoginPage(){
    PageFactory.initElements(driver,this);
}
public String getTitle(){
    return driver.getTitle();

}
public void clickLogin(){
    homeLoginButton.click();
}
public void enterCredentials(String un,String pw){
    emailText.sendKeys(un);
    passEnter.sendKeys(pw);
}
public HomePage loginSuccess(){
    loginEnter.click();
    return new HomePage();
}

}
