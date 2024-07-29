package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AboutPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class AboutUsPageTest extends TestBase {
    AboutPage aboutPage;

    public AboutUsPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        try {
            initialization();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        aboutPage=new AboutPage();
    }

    @Test
    public void aboutUsPageTest(){
        aboutPage.aboutUsPage();
    }
}
