package com.biofourmis.cucumber.pageObject;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.biofourmis.cucumber.helpers.Constants;


public class WebPageObject {

    protected static WebDriver driver;

    public WebPageObject(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public Object navigateToWebPage(String sWebPageLink) {

        driver.get(sWebPageLink);
        return null;
    }

    public static void getScreenShots(WebDriver webDriver, String sScreenShotName, String sFilePath, String sSubFolder) {

        if (Constants.GET_SCREEN_SHOTS) {

            TakesScreenshot screen = null;
            screen = (TakesScreenshot) webDriver;
            File Source = screen.getScreenshotAs(OutputType.FILE);

            if (Constants.ADD_SUB_FOLDER_CREATION) {
                try {
                    DateFormat FolderDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String sTime = FolderDateFormat.format(new Date());
                    File timeDir = new File(sFilePath + sTime);
                    if (!timeDir.exists()) {
                        timeDir.mkdir();
                    }
                    sFilePath = sFilePath + sTime + Constants.FOLDER_SEPERATOR;
                    File tempFileSub = new File(sFilePath + sSubFolder);
                    if (!tempFileSub.exists()) {
                        tempFileSub.mkdir();
                    }

                    sFilePath = sFilePath + sSubFolder;
                } catch (Exception e) {
                    System.out.println("--------Exception occured--getScreenShots Method(Sub folder Creation)-------" + e);
                }

            }

            try {
                FileUtils.copyFile(Source, new File(sFilePath + sScreenShotName + Constants.IMAGE_EXTENSION));

            } catch (IOException e) {
                System.out.println("--------Exception occured---------" + e);
                e.printStackTrace();
            }
        }
    }

}