package org.joguzmandev.demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public abstract class BaseTest {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp() {
        //Load ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Instance new ChromeDrive
        webDriver = new ChromeDriver();
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void disposeWebDriver(ITestResult testResult) throws IOException {

        synchronized (this){
            if(!testResult.isSuccess()){
                File currentScreenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(currentScreenshot,new File(System.getProperty("user.dir")+"\\photo\\"+testResult.getName()+"_"+System.currentTimeMillis()+".png"));
            }
            webDriver.close();
        }

    }
}
