package com.crm.qa.Utils;

import com.crm.qa.base.TestBase;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class TestUtil extends TestBase {
    public static int Implicit_Wait=20;
    static Workbook book;
    static Sheet sheet;
    public static String sheetPath="/Users/prateekbhardwaj/IdeaProjects/CRM/src" +
            "/main/java/com/crm/qa/testdata/SampleData.numbers";

    public void switchFrames(){
        driver.switchTo().frame("mainpannel");
    }

    public static Object [][]getTestData(String sheetName) throws IOException {
        FileInputStream file=null;
        try {
            file=new FileInputStream(sheetPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        book= WorkbookFactory.create(file);
        sheet=book.getSheet(sheetName);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(i).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
    public void takeScreenshotAtFailure(){
        File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String curDir=System.getProperty("user.dir");
        File dest=null;

        if(prop.getProperty("osName").startsWith("Mac")){
             dest=new File(curDir + "\\Screenshot\\"
                    + System.currentTimeMillis() + ".png");
             System.out.println(dest);
        }
        else {
            dest=new File(curDir + "/Screenshot/"
                    + System.currentTimeMillis() + ".png");
        }
        try {
            Files.copy(scrFile.toPath(), dest.toPath());
            //FileHandler.copy(scrFile,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
