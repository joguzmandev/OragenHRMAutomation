package org.joguzmandev.demo.base;

import helpers.TakeScreenShotHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //Instance new ChromeDrive
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void disposeWebDriver(ITestResult testResult){
            webDriver.close();
    }
}
