package com.crm.qa.base;

import com.crm.qa.Utils.TestUtil;

import org.apache.commons.compress.utils.FileNameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    public TestBase(){
        prop=new Properties();
        FileInputStream file= null;
        try {
            file = new FileInputStream("/Users/prateekbhardwaj/IdeaProjects/CRM/src" +
                    "/main/java/com" +
                    "/crm/qa/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialization() throws FileNotFoundException {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("Webdriver.chrom.driver","/Users/prateekbhardwaj/Desktop/ChromDriver");
            driver=new ChromeDriver();
        }
        if(browserName.equals("safari")){
            driver=new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait));
        driver.get(prop.getProperty("url"));
    }


}
